/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import static snakes.Constants.SIZE_IN_PIXEL;

/**
 *
 * @author Tomy
 */
abstract class AItem implements Cloneable {

    protected ImageIcon image;
    protected ItemType type;
    protected Color color;
    
    private Position position;
    private Generator gen;

    public AItem() {
        this.gen = Generator.getInstance();
    }

    public ImageIcon getImage() {
        return image;
    }

    public ItemType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }
    
    public void locateItem(){
        this.position = gen.getRandCoordinate();
    }
    
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(position.getX(), position.getY(), SIZE_IN_PIXEL, SIZE_IN_PIXEL);
    }
    
    //shallow copy (plytka kopia)
    @Override
    public AItem clone() throws CloneNotSupportedException{
        return (AItem)super.clone();
    }
    
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//      Object clone = null;
//      
//      try {
//         clone = super.clone();
//         
//      } catch (CloneNotSupportedException e) {
//      }
//      
//      return clone;
//   }
    
}
