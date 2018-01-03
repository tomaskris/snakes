/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field;

import enums.TypeField;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Tomy
 */
public abstract class Field {
    
    protected Position position;
    protected ImageIcon icon;
    protected TypeField typeField;

    public void changePosition(Position position) {
        this.position = position;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public ImageIcon getIcon() {
        return icon;
    }

    public TypeField getTypeField() {
        return typeField;
    }
    
    public void draw(Graphics2D g2){
        g2.drawImage(icon.getImage(), position.getX(), position.getY(), null);
    }
    
    public void changeImagePath(String path) {
        this.icon = new ImageIcon(getClass().getResource(path));
    }

}
