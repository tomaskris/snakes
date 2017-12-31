/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import field.Position;
import snakestate.ISnakeState;
import snakestate.SnakeDown;
import snakestate.SnakeBody;
import enums.Direction;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomy
 */
public class Snake {

    private ISnakeState state;

    public Snake(Position position) {
        this.state = new SnakeDown(position, new ArrayList<>());
    };

    public void move() {
        state.move();
    }

    public void draw(Graphics2D g2) {
        state.draw(g2);
    }

    public Direction getDirection() {
        return state.getDirection();
    }

    public Position getPosition() {
        return state.getPosition();
    }

    public void turnLeft() {
        state = state.turnLeft();
    }

    public void moveUp() {
        state = state.moveUp();
    }

    public void moveDown() {
        state = state.moveDown();
    }

    public void turnRight() {
        state = state.turnRight();
    }

    public void expandBody() {
        state.expandBody();
    }

    public List<SnakeBody> getBody() {
        return state.getBody();
    }
}
