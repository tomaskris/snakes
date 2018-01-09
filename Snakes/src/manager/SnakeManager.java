/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import enums.TypeSpeed;
import static enums.TypeSpeed.*;
import field.Field;
import field.snake.Snake;
import java.awt.Graphics2D;
import java.util.ArrayList;
import player.Player;
import states.IFieldState;
import keyboard.IKeyboard;
import states.FieldDown;
import states.FieldLeft;
import states.FieldRight;
import states.FieldUp;

/**
 *
 * @author Tomy
 */
public class SnakeManager extends Manager {

    private Player player;
    private boolean isStarted;
    private boolean isLive;
    private TypeSpeed speed; //suvisi s rychlostou hada
    private Thread thread;

    public SnakeManager(Graphics2D graphic, Player player) {
        super(graphic);
        this.player = player;
        this.isStarted = false;
        this.isLive = true;
        this.drawField = new ArrayList<>();
        drawField.add(getGenerator().getRandSnake());
        this.speed = NORMAL;
    }

    @Override
    public void draw() {
        if (isLive) {
            String path = "";
            IFieldState snake = null;
            for (int i = 0; i < drawField.size(); i++) {
                snake = drawField.get(i);
                if (i == 0) {
                    path = "/images/snakes/" + player.getTypeSnake().getName() + "/head"
                            + snake.getDirection().name() + ".png";
                    snake.getField().changeImagePath(path);
                } else {
                    path = "/images/snakes/" + player.getTypeSnake().getName() + "/body.png";
                    snake.getField().changeImagePath(path);
                }
                snake.draw(getGraphics());
            }
        }
    }

    @Override
    public void move() {
        if (isStarted) {
            IFieldState partBody = null;
            for (int i = drawField.size() - 1; i > 0; i--) {
                partBody = drawField.get(i);
                partBody.move();
                changeState(i, drawField.get(i - 1));
            }
            drawField.get(0).move();
        }
    }

    private IFieldState getHead() {
        return drawField.get(0);
    }

    public void expandBody() {
        //pridam cast tela za hlavu
        drawField.add(1, createPartBody());
        //posuniem hlavu
        drawField.get(0).move();
    }

    public void narrowBody() {
        int index;
        //ak to nieje hlava
        if ((index = drawField.size()) > 1) {
            //odoberiem z konca cast tela, ak existuje
            drawField.remove(index - 1);
        }
    }

    private IFieldState createPartBody() {
        Field partField = new Snake();
        partField.changePosition(getHead().getPosition());
        switch (getHead().getDirection()) {
            case DOWN:
                return new FieldDown(partField);
            case UP:
                return new FieldUp(partField);
            case LEFT:
                return new FieldLeft(partField);
            case RIGHT:
                return new FieldRight(partField);
            default:
                return null;
        }
    }

    private void changeState(int indexCurBody, IFieldState followBody) {
        switch (followBody.getDirection()) {
            case DOWN:
                drawField.set(indexCurBody, drawField.get(indexCurBody).moveDown());
                break;
            case UP:
                drawField.set(indexCurBody, drawField.get(indexCurBody).moveUp());
                break;
            case LEFT:
                drawField.set(indexCurBody, drawField.get(indexCurBody).turnLeft());
                break;
            case RIGHT:
                drawField.set(indexCurBody, drawField.get(indexCurBody).turnRight());
                break;
        }
    }

    public void addScoreToPlayer(int score) {
        player.increaseScore(score);
    }
    
    public void fastSpeed() {
        this.speed = FAST;
        checkThredAndSetNormalSpeed();
    }

    public void slowSpeed() {
        this.speed = SLOW;
        checkThredAndSetNormalSpeed();
    }
    
    private void checkThredAndSetNormalSpeed(){
        if(thread != null && thread.isAlive()){
            thread = null;
        }
        normalSpeed();
    }

    private void normalSpeed() {
        this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    speed = NORMAL;
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
    }

    public TypeSpeed getSpeed() {
        return speed;
    }

    public IKeyboard getKeyboard() {
        return player.getKeyboard();
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerName() {
        return player.getName();
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean bool) {
        this.isLive = bool;
    }

    @Override
    public void moveUp() {
        isStarted = true;
        drawField.set(0, drawField.get(0).moveUp());
    }

    @Override
    public void moveDown() {
        isStarted = true;
        drawField.set(0, drawField.get(0).moveDown());
    }

    @Override
    public void turnLeft() {
        isStarted = true;
        drawField.set(0, drawField.get(0).turnLeft());
    }

    @Override
    public void turnRight() {
        isStarted = true;
        drawField.set(0, drawField.get(0).turnRight());
    }

}
