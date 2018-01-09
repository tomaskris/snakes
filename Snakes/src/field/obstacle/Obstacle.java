package field.obstacle;

import enums.TypeField;
import field.Field;

/**
 *
 * @author Tomáš
 */
public abstract class Obstacle extends Field {

    public Obstacle() {
        this.typeField = TypeField.OBSTACLE;
    }

}
