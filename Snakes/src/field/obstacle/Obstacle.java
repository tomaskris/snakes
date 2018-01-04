/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.obstacle;

import enums.TypeField;
import field.Field;

/**
 *
 * @author Tomy
 */
public abstract class Obstacle extends Field {

    public Obstacle() {
        this.typeField = TypeField.OBSTACLE;
    }

}
