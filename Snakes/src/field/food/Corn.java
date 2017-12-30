/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_CORN;
import enums.TypeEffect;
import javax.swing.ImageIcon;

/**
 *
 * @author Tomy
 */
public class Corn extends Food {

    public Corn() {
        this.icon = new ImageIcon(getClass().getResource(IMAGE_CORN));
        
        this.score = 5;
        this.typeEffect = TypeEffect.NOTHING;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Corn();
    }
    
}
