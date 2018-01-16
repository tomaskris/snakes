package manager;

import enums.TypeSnake;
import enums.TypeSpeed;
import static enums.TypeSpeed.*;
import field.Field;
import field.snake.Snake;
import java.awt.Graphics2D;
import java.util.ArrayList;
import player.Player;
import states.FieldDown;
import states.FieldLeft;
import states.FieldRight;
import states.FieldUp;

/**
 *
 * @author Tomáš
 */
public class SnakeManager extends Manager {

//    private Player player;
    private boolean isStarted;
    private boolean isLive;
    private TypeSpeed speed; //suvisi s rychlostou hada
    private Thread thread;
    private TypeSnake typeSnake; //typ hada

//    public SnakeManager(Graphics2D graphic, Player player) {
//        super(graphic);
//        this.player = player;
//        this.isStarted = false;
//        this.isLive = true;
//        this.drawField = new ArrayList<>();
//        drawField.add(getGenerator().getSnake());
//        this.speed = NORMAL;
//    }

    public SnakeManager(Graphics2D graphic, TypeSnake typeSnake) {
        super(graphic);
//        this.player = player;
        this.isStarted = false;
        this.isLive = true;
        this.drawField = new ArrayList<>();
        drawField.add(getGenerator().getSnake());
        this.speed = NORMAL;
        this.typeSnake = typeSnake;
    }
    
    @Override
    public void draw() {
        if (!isLive) {
            return;
        }

        String path;
        Field snake = null;
        for (int i = 0; i < drawField.size(); i++) {
            snake = drawField.get(i);
            if (i == 0) {
                path = "/images/snakes/" + typeSnake.getName() + "/head"
                        + snake.getDirection().name() + ".png";
            } else {
                path = "/images/snakes/" + typeSnake.getName() + "/body.png";
            }
            snake.changeImagePath(path);
            snake.draw(getGraphics());
        }

    }

    @Override
    public void move() {
        if (!isStarted) {
            return;
        }

        Field partBody = null;
        for (int i = drawField.size() - 1; i > 0; i--) {
            partBody = drawField.get(i);
            partBody.move();
            changeState(i, drawField.get(i - 1));
        }
        drawField.get(0).move();
    }

    private Field getHead() {
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

    private Field createPartBody() {
        switch (getHead().getDirection()) {
            case DOWN:
                return new Snake(new FieldDown(getHead().getPosition()));
            case UP:
                return new Snake(new FieldUp(getHead().getPosition()));
            case LEFT:
                return new Snake(new FieldLeft(getHead().getPosition()));
            case RIGHT:
                return new Snake(new FieldRight(getHead().getPosition()));
            default:
                return null;
        }
    }

    private void changeState(int indexCurBody, Field followBody) {
        switch (followBody.getDirection()) {
            case DOWN:
                drawField.get(indexCurBody).moveDown();
                break;
            case UP:
                drawField.get(indexCurBody).moveUp();
                break;
            case LEFT:
                drawField.get(indexCurBody).turnLeft();
                break;
            case RIGHT:
                drawField.get(indexCurBody).turnRight();
                break;
        }
    }

//    public void addScoreToPlayer(int score) {
//        player.increaseScore(score);
//    }

    public void fastSpeed() {
        this.speed = FAST;
        checkThredAndSetNormalSpeed();
    }

    public void slowSpeed() {
        this.speed = SLOW;
        checkThredAndSetNormalSpeed();
    }

    private void checkThredAndSetNormalSpeed() {
        if (thread != null && thread.isAlive()) {
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

//    public IKeyboard getKeyboard() {
//        return player.getKeyboard();
//    }
//
//    public int getPlayerScore() {
//        return player.getScore();
//    }
//
//    public String getPlayerName() {
//        return player.getName();
//    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean bool) {
        this.isLive = bool;
    }

    @Override
    public void moveUp() {
        isStarted = true;
        drawField.get(0).moveUp();
    }

    @Override
    public void moveDown() {
        isStarted = true;
        drawField.get(0).moveDown();
    }

    @Override
    public void turnLeft() {
        isStarted = true;
        drawField.get(0).turnLeft();
    }

    @Override
    public void turnRight() {
        isStarted = true;
        drawField.get(0).turnRight();
    }

}
