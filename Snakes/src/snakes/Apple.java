/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Tomy
 */
public class Apple extends AItem {

    public Apple(Color color) {
        this.type = ItemType.APPLE;
        this.image = new ImageIcon("/images/apple.png");
        this.color = color;
    }

    @Override
    protected AItem clone() {
        return new Apple(getColor());
    }

    
}
