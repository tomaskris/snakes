/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakestate;

import enums.Direction;
import java.util.List;
import field.Position;
import static constants.Constants.SIZE_IN_PIXEL;

/**
 *
 * @author Tomy
 */
public class SnakeRight extends SnakeState {
    
    public SnakeRight(Position position, List<SnakeBody> body) {
        super(position, body);
        this.direction = Direction.RIGHT;
    }

    @Override
    public ISnakeState moveUp() {
        return new SnakeUp(position, getBody());
    }

    @Override
    public ISnakeState moveDown() {
        return new SnakeDown(position, getBody());
    }

    @Override
    public void move() {
        moveBody();
        setPosition(new Position(position.getX() + SIZE_IN_PIXEL, position.getY()));
    }
    
    @Override
    public void setPosition(Position position) {
        super.setPosition(position); //To change body of generated methods, choose Tools | Templates.
    }
    
}
