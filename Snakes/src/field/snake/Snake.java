package field.snake;

import enums.TypeField;
import field.Field;
import states.IFieldState;

/**
 *
 * @author Tomáš
 */
public class Snake extends Field {

    public Snake(IFieldState state) {
        super(state);
        this.typeField = TypeField.SNAKE;
    }

}
