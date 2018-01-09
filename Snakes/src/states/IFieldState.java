package states;

import enums.TypeDirection;
import field.Field;
import java.awt.Graphics2D;
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

    public void draw(Graphics2D g2);

    public TypeDirection getDirection();

    public Position getPosition();

    public Field getField();

}
