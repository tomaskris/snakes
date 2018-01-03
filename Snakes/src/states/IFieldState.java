/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import enums.Direction;
import field.Field;
import java.awt.Graphics2D;
import field.Position;

/**
 *
 * @author Tomy
 */
public interface IFieldState {
    
    public IFieldState moveUp();
    public IFieldState moveDown();
    public IFieldState turnLeft();
    public IFieldState turnRight();
    public void move();
    public void draw(Graphics2D g2);
    public Direction getDirection();
    public Position getPosition();
    public Field getField();
    
}
