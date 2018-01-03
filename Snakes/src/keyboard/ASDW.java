/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import java.awt.event.KeyEvent;
import manager.Manager;

/**
 *
 * @author Tomy
 */
public class ASDW implements IKeyboard {

    @Override
    public boolean isKeyPressed(int key, Manager manager) {
        switch (key) {
            case KeyEvent.VK_W:
                manager.moveUp();
                return true;
            case KeyEvent.VK_S:
                manager.moveDown();
                return true;
            case KeyEvent.VK_A:
                manager.turnLeft();
                return true;
            case KeyEvent.VK_D:
                manager.turnRight();
                return true;
            default: return false;
        }
    }

}
