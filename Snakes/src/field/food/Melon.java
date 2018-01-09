/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_MELON;
import enums.TypeEffect;
import javax.swing.ImageIcon;

/**
 *
 * @author Tomáš
 */
public class Melon extends Food {

    public Melon() {
        this.icon = new ImageIcon(getClass().getResource(IMAGE_MELON));
        
        this.score = 17;
        this.typeEffect = TypeEffect.SPEED_DOWN;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Melon();
    }
    
}
