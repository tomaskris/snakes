package manager;

import field.Field;
import generator.Generator;
import java.awt.Graphics2D;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public abstract class Manager {

    private Graphics2D graphics;
    private final Generator generator;
    protected List<Field> drawField;

    public Manager(Graphics2D graphics) {
        this.graphics = graphics;
        this.generator = Generator.getInstance();
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public void updateGraphics(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public Generator getGenerator() {
        return generator;
    }

    public List<Field> getDrawField() {
        return drawField;
    }

    public abstract void draw();

    public abstract void move();

    public abstract void moveUp();

    public abstract void moveDown();

    public abstract void turnLeft();

    public abstract void turnRight();

}
