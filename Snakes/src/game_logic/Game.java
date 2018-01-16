package game_logic;

import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import collisions.Collisions;
import field.food.Food;
import java.awt.Font;
import keyboard.Keyboard;
import manager.FoodManager;
import manager.Manager;
import manager.SnakeManager;
import player.Player;

/**
 *
 * @author Tomáš
 */
public class Game extends GameEngine {

    //BufferStrategy na vykreslovanie s metodou double-buffer
    private BufferStrategy bs;
    //bool hodnota ci sme este v hre alebo sme prehrali
    private boolean inGame;

    private Manager foodManager;
    private List<Player> players;
    private int deadPlayers;

    public Game(BufferStrategy bs) {
        this.bs = bs;
        this.players = new ArrayList<>();
        this.foodManager = new FoodManager(getGraphics());
        this.deadPlayers = 0;
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }
    
    public boolean addPlayer(String name, Keyboard keyboard, SnakeManager snake) {
        return players.add(new Player(name, keyboard, snake));
    }

    private Graphics2D getGraphics() {
        return (Graphics2D) bs.getDrawGraphics();
    }

    public void createNewGame() {
        inGame = true;
        startGameLoop();
    }

    @Override
    public boolean shouldRunGameLoop() {
        return deadPlayers != players.size();
    }

    @Override
    public void update() {
        SnakeManager snake;
        for (Player player : players) {
            snake = (SnakeManager) player.getSnakeManager();
            if (updateTick % snake.getSpeed().getValue() == 0) {
                updateLogic(player);
            }
        }
    }

    @Override
    public void render() {
        Graphics2D g2 = getGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(10, 30, MAX_WIDTH_GAME_BOARD + 10, MAX_HEIGHT_GAME_BOARD + 10);

        for (Player player : players) {
            player.getSnakeManager().draw();
        }
        foodManager.draw();
        g2.dispose();
        bs.show();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void onGameLoopStop() {
        gameOver();
    }

    private void updateLogic(Player player) {
        SnakeManager snake = player.getSnakeManager();
        if (!player.getSnakeManager().isLive()) {
            return;
        }

        // ak narazil, kill him
        if (Collisions.checkCollision(snake.getDrawField())) {
            killPlayer(snake);
            return;
        }

        Food eatenFood = Collisions.checkEatenFood(snake.getDrawField(), foodManager.getDrawField());
        // ak nezjedol jedlo, over kolizie s ostatnymi hracmi
        if (eatenFood == null) {
            snake.move();
            if (Collisions.checkSnakesCollision(snake, players)) {
                killPlayer(snake);
            }

            return;
        }

        player.increaseScore(eatenFood.getScore());
        switch (eatenFood.getTypeEffect()) {
            case EXPAND_BODY:
                snake.expandBody();
                break;
            case NARROW_BODY:
                snake.narrowBody();
                break;
            case SPEED_UP:
                snake.fastSpeed();
                break;
            case SPEED_DOWN:
                snake.slowSpeed();
                break;
            default:
                break;
        }

    }

    private void sortPlayers() {
        players.sort((Player z1, Player z2) -> {
            if (z1.getScore() < z2.getScore()) {
                return 1;
            }
            if (z1.getScore() > z2.getScore()) {
                return -1;
            }
            return 0;
        });
    }

    public void gameOver() {
        inGame = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Graphics2D g2 = getGraphics();

        String message = "Game Over!";
        Font font = new Font("Helvetica", Font.BOLD, 20);

        g2.setColor(Color.BLACK);
        g2.fillRect(10, 30, MAX_WIDTH_GAME_BOARD + 10, MAX_HEIGHT_GAME_BOARD + 10);

        g2.setColor(Color.WHITE);
        g2.setFont(font);
        g2.drawString(message, (MAX_WIDTH_GAME_BOARD / 2) - 30, 100);
        int pom = 130;
        sortPlayers();
        for (Player player : players) {
            message = player.getName() + " >> " + player.getScore() + " points";
            g2.drawString(message, (MAX_WIDTH_GAME_BOARD / 2) - 100, pom);
            pom += 25;
        }
        g2.drawString(">> Press any key to continue <<", 40, 300);

        g2.dispose();

        bs.show();

        Toolkit.getDefaultToolkit().sync();
    }

    public void killPlayer(SnakeManager player) {
        player.setLive(false);
        deadPlayers++;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isInGame() {
        return inGame;
    }

}
