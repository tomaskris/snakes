/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_GRAPES;
import enums.TypeEffect;
import javax.swing.ImageIcon;
import states.IFieldState;

/**
 *
 * @author Tomáš
 */
public class Grapes extends Food {

    public Grapes(){
        this.icon = new ImageIcon(getClass().getResource(IMAGE_GRAPES));
        
        this.score = 12;
        this.typeEffect = TypeEffect.EXPAND_BODY;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Grapes();
    }
    
}
