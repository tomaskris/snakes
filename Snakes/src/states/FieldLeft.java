package states;

import static constants.Constants.SIZE_IN_PIXEL;
import enums.TypeDirection;
import field.Position;

/**
 *
 * @author Tomáš
 */
public class FieldLeft extends FieldState {

    public FieldLeft(Position position) {
        super(position);
        this.direction = TypeDirection.LEFT;
    }

    @Override
    public IFieldState moveDown() {
        return new FieldDown(position);
    }

    @Override
    public IFieldState moveUp() {
        return new FieldUp(position);
    }

    @Override
    public void move() {
        setPosition(new Position(getPosition().getX() - SIZE_IN_PIXEL, getPosition().getY()));
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

}
