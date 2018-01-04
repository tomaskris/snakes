/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import enums.TypeDirection;
import field.Field;
import field.Position;
import java.awt.Graphics2D;

/**
 *
 * @author Tomy
 */
abstract class FieldState implements IFieldState {

    protected Field field;
    protected TypeDirection direction;
    
    public FieldState(Field field) {
        this.field = field;
    }

    @Override
    public void draw(Graphics2D g2) {
        field.draw(g2);
    }

    @Override
    public TypeDirection getDirection() {
        return direction;
    }

    @Override
    public Position getPosition() {
        return field.getPosition();
    }
    
    public void setPosition(Position position) {
        this.field.changePosition(position);
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public IFieldState moveUp() {
        return this;
    }

    @Override
    public IFieldState moveDown() {
        return this;
    }

    @Override
    public IFieldState turnLeft() {
        return this;
    }

    @Override
    public IFieldState turnRight() {
        return this;
    }
    
}
