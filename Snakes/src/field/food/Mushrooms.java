/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_MUSHROOMS;
import enums.TypeEffect;
import javax.swing.ImageIcon;

/**
 *
 * @author Tomáš
 */
public class Mushrooms extends Food {

    public Mushrooms() {
        this.icon = new ImageIcon(getClass().getResource(IMAGE_MUSHROOMS));
        
        this.score = 10;
        this.typeEffect = TypeEffect.EXPAND_BODY;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Mushrooms();
    }
    
}
