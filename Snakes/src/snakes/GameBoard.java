/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

public class GameBoard extends JPanel implements Runnable {

    private static final long serialVersionUID = 7806414151208424260L;

    /**
     * Šíøka herního pole
     */
    private final int WIDTH;
    /**
     * Výška herního pole
     */
    private final int HEIGHT;
    /**
     * Instance tøídy Snake
     */
//    private Snake snake;
    private Snake snake;
    /**
     * Instance tøídy Bonus
     */
//    private Bonus bonus;
    /**
     * Informace zda jsme ještì ve høe, nebo jsme prohráli
     */
    private boolean inGame;

    /**
     * instance tøídy BufferStrategy na vykreslování s metodou double-buffer
     */
    private BufferStrategy bs;

    /**
     * FPS (1000/FRAME_DELAY), ovlivòuje rychlost hry
     */
    private final int FRAME_DELAY = 100;
    /**
     * Jak dlouho bìžel jeden cyklus, pomocná promìnná pøi synchronizaci FPS
     */
    private long cycleTime;

    private ItemManager itemManager;
    private Generator generator;
    private AItem item;

    /**
     *
     * @param width šíøka herního pole
     * @param height výška herního pole
     * @param bs instance tøídy bufferstrategy na vykreslování
     */
    public GameBoard(int width, int height, BufferStrategy bs) {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setIgnoreRepaint(true);
        WIDTH = width;
        HEIGHT = height;
        this.bs = bs;
        this.itemManager = new ItemManager();
        this.generator = Generator.getInstance();

        gameInit();
    }

    /**
     * Nastavení hry a její zapnutí
     */
    private void gameInit() {
        inGame = true;
        snake = new Snake(new Position(50, 50));
        itemManager.loadItems();
        item = itemManager.getRandomItem();

        Thread animace = new Thread(this, "Game");
        animace.start();
    }

    /**
     * Hlavní smyèka, kde probíhá furt dokola aktualizace herní logiky,
     * pøekreslování a synchronizace FPS
     */
    @Override
    public void run() {

        cycleTime = System.currentTimeMillis();

        while (inGame) {

            updateLogic();

            updateGui();

            synchFrameRate();

        }

        gameOver();

    }

    /**
     * Synchronizace FPS
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
     * Vykreslení herní plochy
     */
    private void updateGui() {
        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();
        g2.setColor(Color.BLACK); //vyèištìní
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        snake.draw(g2);//draw(g2);
        item.draw(g2);

        g2.dispose();

        bs.show();

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Kontrola kolizí a posun hada
     */
    private void updateLogic() {
        if (Collisions.checkCollision(snake, WIDTH, HEIGHT)) {
            inGame = false;
        } else if (Collisions.checkBonus(snake, item)) {
            snake.expandBody();
            item = itemManager.getRandomItem();
        } else {
            snake.move();
        }
    }

    /**
     * Zobrazení obrazovky s nápisem prohry a se skórem
     */
    private void gameOver() {
        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        String zprava = "Prehral si!";
        String skore = "Dosiahol si skóre: ";//+ snake.getBody().size();
        Font font = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = this.getFontMetrics(font);

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        g2.setColor(Color.WHITE);
        g2.setFont(font);
        g2.drawString(zprava, (WIDTH - metr.stringWidth(zprava)) / 2, (HEIGHT / 2) + 25);
        g2.drawString(skore, (WIDTH - metr.stringWidth(skore)) / 2, (HEIGHT / 2) - 25);

        g2.dispose();

        bs.show();

        Toolkit.getDefaultToolkit().sync();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    /**
     * Soukromá tøída která zpracovává zmáèknuté klávesy
     */
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //int hodnota zmáèknuté klávesy
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && (snake.getDirection() != Direction.DOWN)) {
                snake.moveUp();
            }
            if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && (snake.getDirection() != Direction.LEFT)) {
                snake.turnRight();
            }
            if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && (snake.getDirection() != Direction.UP)) {
                snake.moveDown();
            }
            if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && (snake.getDirection() != Direction.RIGHT)) {
                snake.turnLeft();
            }
        }
    }

}
