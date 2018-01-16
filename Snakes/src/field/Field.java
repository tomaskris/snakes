package field;

import enums.TypeDirection;
import enums.TypeField;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import states.FieldDown;
import states.IFieldState;

/**
 *
 * @author Tomáš
 */
public abstract class Field {

    protected ImageIcon icon;
    protected TypeField typeField;
    
    private IFieldState state; 

    public Field(IFieldState state) {
        this.state = state;
    }
    
    public Field() {
        this.state = new FieldDown(null);
    }

    public void changePosition(Position position) {
        this.state.setPosition(position);
    }

    public Position getPosition() {
        return state.getPosition();
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public TypeField getTypeField() {
        return typeField;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(icon.getImage(), getPosition().getX(), getPosition().getY(), null);
    }

    public void changeImagePath(String path) {
        this.icon = new ImageIcon(getClass().getResource(path));
    }

    public IFieldState getState() {
        return state;
    }
    
    public TypeDirection getDirection() {
        return state.getDirection();
    }

    public void turnLeft() {
        state = state.turnLeft();
    }

    public void moveUp() {
        state = state.moveUp();
    }

    public void moveDown() {
        state = state.moveDown();
    }

    public void turnRight() {
        state = state.turnRight();
    }
    
    public void move() {
        state.move();
    }

}
