/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import enums.Direction;
import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author Tomy
 */
public interface ISnakeState {
    
    public ISnakeState moveUp();
    public ISnakeState moveDown();
    public ISnakeState turnLeft();
    public ISnakeState turnRight();
    public void move();
    public void draw(Graphics2D g2);
    public Direction getDirection();
    public Position getPosition();
    
    public void expandBody();
    public List<SnakeBody> getBody();
    
}
