package states;

import static constants.Constants.SIZE_IN_PIXEL;
import enums.TypeDirection;
import field.Field;
import field.Position;

/**
 *
 * @author Tom�
 */
public class FieldUp extends FieldState {

    public FieldUp(Field field) {
        super(field);
        this.direction = TypeDirection.UP;
    }

    @Override
    public IFieldState turnLeft() {
        return new FieldLeft(field);
    }

    @Override
    public IFieldState turnRight() {
        return new FieldRight(field);
    }

    @Override
    public void move() {
        setPosition(new Position(getPosition().getX(), getPosition().getY() - SIZE_IN_PIXEL));
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

}
