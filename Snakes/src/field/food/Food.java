/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.food;

import enums.TypeEffect;
import enums.TypeField;
import field.Field;

/**
 *
 * @author Tomy
 */
public abstract class Food extends Field {
    
    protected int score; //pocet bodov za zjedenie tohto jedla
    protected TypeEffect typeEffect; //typ efektu, co sa stane hadovi, ked zje toto jedlo
    protected boolean isMoving; //ci sa toto jedlo aj pohybuje po hracej ploche
    
    public Food() {
        this.typeField = TypeField.EAT;
    }

    public int getScore() {
        return score;
    }

    public TypeEffect getTypeEffect() {
        return typeEffect;
    }

    public boolean isMoving() {
        return isMoving;
    }
    
    public abstract Food copy();
    
}
