/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import static constants.Constants.IMAGE_CARROT;
import enums.TypeEffect;
import javax.swing.ImageIcon;

/**
 *
 * @author Tom�
 */
public class Carrot extends Food {

    public Carrot() {
        this.icon = new ImageIcon(getClass().getResource(IMAGE_CARROT));
        
        this.score = 7;
        this.typeEffect = TypeEffect.NARROW_BODY;
        this.isMoving = false;
    }
    
    @Override
    public Food copy() {
        return new Carrot();
    }
    
}
