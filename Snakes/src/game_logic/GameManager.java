/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_logic;

import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import static constants.Constants.FRAME_DELAY;
import enums.TypeSnake;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import keyboard.Arrows;
import collisions.Collisions;
import keyboard.ASDW;
import manager.FoodManager;
import manager.Manager;
import manager.SnakeManager;
import player.Player;

/**
 *
 * @author Tomy
 */
public class GameManager implements Runnable {

    //BufferStrategy na vykreslovanie s metodou double-buffer
    private BufferStrategy bs;
    //ako dlho bezal jeden cyklus, pomocna premenna pri synchronizacii FPS
    private long cycleTime;
    //bool hodnota ci sme este v hre alebo sme prehrali
    private boolean inGame;

    private Manager foodManager;
    private List<Manager> players;
    private int deadPlayers;

    public GameManager(BufferStrategy bs) {
        this.bs = bs;
        this.players = new ArrayList<>();
        this.foodManager = new FoodManager((Graphics2D) bs.getDrawGraphics());
        this.deadPlayers = 0;
    }

    public void createNewGame() {
        players.add(new SnakeManager((Graphics2D) bs.getDrawGraphics(),
                new Player("Player1", TypeSnake.YELLOW_SNAKE, new Arrows())));
        players.add(new SnakeManager((Graphics2D) bs.getDrawGraphics(),
                new Player("Player2", TypeSnake.GREEN_SNAKE, new ASDW())));

        inGame = true;
        Thread animacia = new Thread(this, "Game");
        animacia.start();
    }

    @Override
    public void run() {
        cycleTime = System.currentTimeMillis();

        while (deadPlayers != players.size()) {
            updateLogic();
            updateGui();
            synchFrameRate();
        }
        //koniec hry
        gameOver();
    }

    private void updateLogic() {
        //pre kazdeho hraca
        int plusScore;
        for (Manager player : players) {
            if (((SnakeManager) player).isLive()) {
                if (Collisions.checkCollision(player.getDrawField())) {
                    ((SnakeManager) player).setLive(false);
                    deadPlayers++;
                } else if ((plusScore = Collisions.checkEatenFood(player.getDrawField(), foodManager.getDrawField())) > 0) {
                    ((SnakeManager) player).addScoreToPlayer(plusScore);
                    ((SnakeManager) player).expandBody();
                } else {
                    player.move();
                    if (Collisions.checkSnakesCollision(player, players)) {
                        ((SnakeManager) player).setLive(false);
                        deadPlayers++;
                    }
                }
            }
        }
    }

    /**
     * Synchronizacia FPS
     */
    private void synchFrameRate() {
        cycleTime += FRAME_DELAY;
        long difference = cycleTime - System.currentTimeMillis();
        try {
            Thread.sleep(Math.max(0, difference));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cycleTime = System.currentTimeMillis();
    }

    /**
     * Vykreslenie hernej plochy
     */
    private void updateGui() {
        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();
        g2.setColor(Color.BLACK); //vy�i�t�n�
        g2.fillRect(10, 30, MAX_WIDTH_GAME_BOARD + 10, MAX_HEIGHT_GAME_BOARD + 10);

        for (Manager player : players) {
            player.draw();
        }
        foodManager.draw();
        g2.dispose();
        bs.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void gameOver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    public List<Manager> getPlayers() {
        return players;
    }

}
