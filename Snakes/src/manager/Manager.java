/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import generator.Generator;
import java.awt.Graphics2D;

/**
 *
 * @author Tomy
 */
public abstract class Manager {
    
    private Graphics2D graphics;
    private Generator generator;

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
    
    public abstract void draw();

}
