package states;

import static constants.Constants.SIZE_IN_PIXEL;
import enums.TypeDirection;
import field.Position;

/**
 *
 * @author Tomáš
 */
public class FieldUp extends FieldState {

    public FieldUp(Position position) {
        super(position);
        this.direction = TypeDirection.UP;
    }

    @Override
    public IFieldState turnLeft() {
        return new FieldLeft(position);
    }

    @Override
    public IFieldState turnRight() {
        return new FieldRight(position);
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
