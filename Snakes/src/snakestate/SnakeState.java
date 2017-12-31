/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakestate;

import enums.Direction;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import field.Position;
import static constants.Constants.SIZE_IN_PIXEL;

/**
 *
 * @author Tomy
 */
abstract class SnakeState implements ISnakeState {
    
    protected Position position;
    protected Direction direction;
    
    private List<SnakeBody> body;
    
    public SnakeState(Position position, List<SnakeBody> body) {
        this.position = position;
        this.body = body;
    }
    
    @Override
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLUE);
        g2.fillRect(position.getX(), position.getY(), SIZE_IN_PIXEL, SIZE_IN_PIXEL);

        for (SnakeBody ob : body) {
            ob.draw(g2);
        }
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    protected void moveBody() {
        int tmpX = position.getX(), tmpY = position.getY(), tmp; // pomocné promìnné

        for (SnakeBody obj : body) {
            tmp = obj.getPosition().getX();
            obj.getPosition().setX(tmpX);
            tmpX = tmp;
            tmp = obj.getPosition().getY();
            obj.getPosition().setY(tmpY);
            tmpY = tmp;
        }

    }
    
    @Override
    public void expandBody() {
        body.add(0, new SnakeBody(position, Color.gray));
        moveHead();
    }
    
    private void moveHead(){
        switch (direction) {
            case LEFT:
                setPosition(new Position(position.getX() - SIZE_IN_PIXEL, position.getY()));
                break;
            case RIGHT:
                setPosition(new Position(position.getX() + SIZE_IN_PIXEL, position.getY()));
                break;
            case UP:
                setPosition(new Position(position.getX(), position.getY() - SIZE_IN_PIXEL));
                break;
            case DOWN:
                setPosition(new Position(position.getX(), position.getY() + SIZE_IN_PIXEL));
                break;
        }
    }

    @Override
    public List<SnakeBody> getBody() {
        return body;
    }

    @Override
    public ISnakeState moveUp() {
        return this;
    }

    @Override
    public ISnakeState moveDown() {
        return this;
    }

    @Override
    public ISnakeState turnLeft() {
        return this;
    }

    @Override
    public ISnakeState turnRight() {
        return this;
    }
}
