/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import enums.Direction;
import enums.TypeSnake;
import field.Field;
import field.snake.Snake;
import generator.Generator;
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

    private Generator generator;

    public SnakeManager(Graphics2D graphic, Player player) {
        super(graphic);
        this.generator = Generator.getInstance();
        this.player = player;
        this.drawField = new ArrayList<>();
        drawField.add(generator.getRandSnake());
    }

    @Override
    public void draw() {
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

//        String path = "";
//        IFieldState snake = null;
//        Direction previous = null;
//        for (int i = 0; i < drawField.size(); i++) {
//            snake = drawField.get(i);
//            if (previous == null) {
//                path = "/images/snakes/" + player.getTypeSnake().getName() + "/head"
//                        + snake.getDirection().name() + ".png";
//                snake.getField().changeImagePath(path);
//            } else {
////                path = "/images/snakes/" + player.getTypeSnake().getName() + "/body"
////                        + snake.getDirection().name() + ".png";
////                snake.getField().changeImagePath(path);
//                changePathIconBody(snake, previous);
//            }
//            previous = snake.getDirection();
//            snake.draw(getGraphics());
//        }
    }

    private void changePathIconBody(IFieldState snake, Direction previous) {
        Direction curDir = snake.getDirection();
        if(curDir.equals(previous)){
            snake.getField().changeImagePath("/images/snakes/"
                    + player.getTypeSnake().getName() + "/body"
                    + curDir.name() + ".png");
        } else {
            if(curDir.equals(Direction.LEFT) && previous.equals(Direction.DOWN)
                    || curDir.equals(Direction.UP) && previous.equals(Direction.RIGHT)){
                snake.getField().changeImagePath("/images/snakes/"
                    + player.getTypeSnake().getName() + "/turnLU.png");
            } else 
            if(curDir.equals(Direction.DOWN) && previous.equals(Direction.RIGHT)
                    || curDir.equals(Direction.LEFT) && previous.equals(Direction.UP)){
                snake.getField().changeImagePath("/images/snakes/"
                    + player.getTypeSnake().getName() + "/turnLD.png");
            } else 
            if(curDir.equals(Direction.RIGHT) && previous.equals(Direction.DOWN)
                    || curDir.equals(Direction.UP) && previous.equals(Direction.LEFT)){
                snake.getField().changeImagePath("/images/snakes/"
                    + player.getTypeSnake().getName() + "/turnRU.png");
            } else {
//            if(curDir.equals(Direction.RIGHT) && previous.equals(Direction.UP)
//                    || curDir.equals(Direction.DOWN) && previous.equals(Direction.LEFT)){
                snake.getField().changeImagePath("/images/snakes/"
                    + player.getTypeSnake().getName() + "/turnRD.png");
            }
        }
    }

    @Override
    public void move() {
//        for (IFieldState snake : drawField) {
//            snake.move();
//        }
        IFieldState partBody = null;
        for (int i = drawField.size() - 1; i > 0; i--) {
            partBody = drawField.get(i);
            partBody.move();
            changeState(i, drawField.get(i - 1));
        }
        drawField.get(0).move();
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

    public IKeyboard getKeyboard() {
        return player.getKeyboard();
    }

    @Override
    public void moveUp() {
        drawField.set(0, drawField.get(0).moveUp());
    }

    @Override
    public void moveDown() {
        drawField.set(0, drawField.get(0).moveDown());
    }

    @Override
    public void turnLeft() {
        drawField.set(0, drawField.get(0).turnLeft());
    }

    @Override
    public void turnRight() {
        drawField.set(0, drawField.get(0).turnRight());
    }

}
