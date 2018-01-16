/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_CHERRY;
import enums.TypeEffect;
import javax.swing.ImageIcon;
import states.IFieldState;

/**
 *
 * @author Tomáš
 */
public class Cherry extends Food {

    public Cherry(){
        this.icon = new ImageIcon(getClass().getResource(IMAGE_CHERRY));
        
        this.score = 10;
        this.typeEffect = TypeEffect.NARROW_BODY;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Cherry();
    }
    
}
