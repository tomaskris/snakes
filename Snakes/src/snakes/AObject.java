/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import field.Position;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import static constants.Constants.SIZE_IN_PIXEL;

/**
 *
 * @author Tomy
 */
public abstract class AObject {
    
    protected ImageIcon image;
    protected Color color;
    
    protected Position position;

    public ImageIcon getImage() {
        return image;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }
    
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(position.getX(), position.getY(), SIZE_IN_PIXEL, SIZE_IN_PIXEL);
    }
    
}
