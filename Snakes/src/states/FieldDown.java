/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import static constants.Constants.SIZE_IN_PIXEL;
import enums.Direction;
import field.Field;
import field.Position;

/**
 *
 * @author Tomy
 */
public class FieldDown extends FieldState {
    
    public FieldDown(Field field) {
        super(field);
        this.direction = Direction.DOWN;
    }
    
    @Override
    public IFieldState turnLeft() {
        return new FieldLeft(field);
    }

    @Override
    public IFieldState turnRight() {
        return new FieldRight(field);
    }

    @Override
    public void move() {
        setPosition(new Position(getPosition().getX(), getPosition().getY() + SIZE_IN_PIXEL));
    }
    
    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }
    
}
