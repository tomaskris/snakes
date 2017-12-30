/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import enums.TypeEffect;
import javax.swing.ImageIcon;
import static constants.Constants.IMAGE_STRAWBERRY;

/**
 *
 * @author Tomy
 */
public class Strawberry extends Food {

    public Strawberry() {
        this.icon = new ImageIcon(getClass().getResource(IMAGE_STRAWBERRY));
        
        this.score = 5;
        this.typeEffect = TypeEffect.NOTHING;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Strawberry();
    }
    
}
