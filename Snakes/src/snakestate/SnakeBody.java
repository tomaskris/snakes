/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakestate;

import java.awt.Color;
import snakes.AObject;
import field.Position;

/**
 *
 * @author Tomy
 */
public class SnakeBody extends AObject {

    public SnakeBody(Position position, Color color) {
        this.position = position;
        this.color = color;
    }
    
}
