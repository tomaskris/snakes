package game_logic;

import actions.ExpandBody;
import actions.NarrowBody;
import actions.SpeedDown;
import actions.SpeedUp;
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
    private List<Manager> players;
    private int deadPlayers;

    public Game(BufferStrategy bs) {
        this.bs = bs;
        this.players = new ArrayList<>();
        this.foodManager = new FoodManager(getGraphics());
        this.deadPlayers = 0;
    }

    public boolean addPlayer(Player player) {
        return players.add(new SnakeManager(getGraphics(), player));
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
        SnakeManager player;
        for (Manager manager : players) {
            player = (SnakeManager) manager;
            if (updateTick % player.getSpeed().getValue() == 0) {
                updateLogic(player);
            }
        }
    }

    @Override
    public void render() {
        Graphics2D g2 = getGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(10, 30, MAX_WIDTH_GAME_BOARD + 10, MAX_HEIGHT_GAME_BOARD + 10);

        for (Manager player : players) {
            player.draw();
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

    private void updateLogic(SnakeManager player) {
        if (!player.isLive()) {
            return;
        }

        // ak narazil, kill him
        if (Collisions.checkCollision(player.getDrawField())) {
            killPlayer(player);
            return;
        }

        Food eatenFood = Collisions.checkEatenFood(player.getDrawField(), foodManager.getDrawField());
        // ak nezjedol jedlo, over kolizie s ostatnymi hracmi
        if (eatenFood == null) {
            player.move();
            if (Collisions.checkSnakesCollision(player, players)) {
                killPlayer(player);
            }

            return;
        }

        player.addScoreToPlayer(eatenFood.getScore());
        switch (eatenFood.getTypeEffect()) {
            case EXPAND_BODY:
                new ExpandBody(player).execute();
                break;
            case NARROW_BODY:
                new NarrowBody(player).execute();
                break;
            case SPEED_UP:
                new SpeedUp(player).execute();
                break;
            case SPEED_DOWN:
                new SpeedDown(player).execute();
                break;
            default:
                break;
        }

    }

    private void sortPlayers() {
        players.sort((Manager z1, Manager z2) -> {
            if (((SnakeManager) z1).getPlayerScore() < ((SnakeManager) z2).getPlayerScore()) {
                return 1;
            }
            if (((SnakeManager) z1).getPlayerScore() > ((SnakeManager) z2).getPlayerScore()) {
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
        for (Manager player : players) {
            message = ((SnakeManager) player).getPlayerName() + " >> " + ((SnakeManager) player).getPlayerScore() + " points";
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

    public List<Manager> getPlayers() {
        return players;
    }

    public boolean isInGame() {
        return inGame;
    }

}
