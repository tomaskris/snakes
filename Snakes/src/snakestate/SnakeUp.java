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
public class SnakeUp extends SnakeState {
    
    public SnakeUp(Position position, List<SnakeBody> body) {
        super(position, body);
        this.direction = Direction.UP;
    }
    
    @Override
    public ISnakeState turnLeft(){
        return new SnakeLeft(position, getBody());
    }

    @Override
    public ISnakeState turnRight() {
        return new SnakeRight(position, getBody());
    }

    @Override
    public void move() {
        moveBody();
        setPosition(new Position(position.getX(), position.getY() - SIZE_IN_PIXEL));
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
