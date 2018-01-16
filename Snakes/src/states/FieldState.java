package states;

import enums.TypeDirection;
import field.Position;

/**
 *
 * @author Tomáš
 */
abstract class FieldState implements IFieldState {

    protected Position position;
    protected TypeDirection direction;

    public FieldState(Position position) {
        this.position = position;
    }

    @Override
    public TypeDirection getDirection() {
        return direction;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public IFieldState moveUp() {
        return this;
    }

    @Override
    public IFieldState moveDown() {
        return this;
    }

    @Override
    public IFieldState turnLeft() {
        return this;
    }

    @Override
    public IFieldState turnRight() {
        return this;
    }

}
