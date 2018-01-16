/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_PINEAPPLE;
import enums.TypeEffect;
import javax.swing.ImageIcon;
import states.IFieldState;

/**
 *
 * @author Tomáš
 */
public class Pineapple extends Food {

    public Pineapple(){
        this.icon = new ImageIcon(getClass().getResource(IMAGE_PINEAPPLE));
        
        this.score = 13;
        this.typeEffect = TypeEffect.EXPAND_BODY;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Pineapple();
    }
    
}
