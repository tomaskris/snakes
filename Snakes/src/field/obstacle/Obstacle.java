package field.obstacle;

import enums.TypeField;
import field.Field;
import states.IFieldState;

/**
 *
 * @author Tomáš
 */
public abstract class Obstacle extends Field {

    public Obstacle(IFieldState state) {
        super(state);
        this.typeField = TypeField.OBSTACLE;
    }

}
