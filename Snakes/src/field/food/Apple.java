/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_APPLE;
import enums.TypeEffect;
import javax.swing.ImageIcon;
import states.IFieldState;

/**
 *
 * @author Tomáš
 */
public class Apple extends Food {

    public Apple(){
        this.icon = new ImageIcon(getClass().getResource(IMAGE_APPLE));
        
        this.score = 15;
        this.typeEffect = TypeEffect.SPEED_UP;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Apple();
    }
    
}
