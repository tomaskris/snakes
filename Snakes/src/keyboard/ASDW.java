/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import actions.KeyDown;
import actions.KeyLeft;
import actions.KeyRight;
import actions.KeyUp;
import java.awt.event.KeyEvent;
import manager.SnakeManager;

/**
 *
 * @author Tomy
 */
public class ASDW implements IKeyboard {

    @Override
    public boolean isKeyPressed(int key, SnakeManager manager) {
        switch (key) {
            case KeyEvent.VK_W:
                new KeyUp(manager).execute();
                return true;
            case KeyEvent.VK_S:
                new KeyDown(manager).execute();
                return true;
            case KeyEvent.VK_A:
                new KeyLeft(manager).execute();
                return true;
            case KeyEvent.VK_D:
                new KeyRight(manager).execute();
                return true;
            default: return false;
        }
    }

}
