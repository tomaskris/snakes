package states;

import enums.TypeDirection;
import field.Position;

/**
 * State design pattern
 *
 * @author Tomáš
 */
public interface IFieldState {

    public IFieldState moveUp();

    public IFieldState moveDown();

    public IFieldState turnLeft();

    public IFieldState turnRight();

    public void move();

    public TypeDirection getDirection();

    public Position getPosition();

    public void setPosition(Position position);

}
