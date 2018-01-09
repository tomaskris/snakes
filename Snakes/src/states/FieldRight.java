package states;

import static constants.Constants.SIZE_IN_PIXEL;
import enums.TypeDirection;
import field.Field;
import field.Position;

/**
 *
 * @author Tomáš
 */
public class FieldRight extends FieldState {

    public FieldRight(Field field) {
        super(field);
        this.direction = TypeDirection.RIGHT;
    }

    @Override
    public IFieldState moveUp() {
        return new FieldUp(field);
    }

    @Override
    public IFieldState moveDown() {
        return new FieldDown(field);
    }

    @Override
    public void move() {
        setPosition(new Position(getPosition().getX() + SIZE_IN_PIXEL, getPosition().getY()));
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

}
