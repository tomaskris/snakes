/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import field.Field;
import generator.Generator;
import java.awt.Graphics2D;
import java.util.List;
import states.IFieldState;

/**
 *
 * @author Tomy
 */
public abstract class Manager {
    
    private Graphics2D graphics;
    private final Generator generator;
    protected List<IFieldState> drawField;
    
    public Manager(Graphics2D graphics) {
        this.graphics = graphics;
        this.generator = Generator.getInstance();
    }

    public Graphics2D getGraphics() {
        return graphics;
    }
    
    public void updateGraphics(Graphics2D graphics){
        this.graphics = graphics;
    }

    public Generator getGenerator() {
        return generator;
    }

    public List<IFieldState> getDrawField() {
        return drawField;
    }

    public abstract void draw();
    public abstract void move();
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void turnLeft();
    public abstract void turnRight();

}
