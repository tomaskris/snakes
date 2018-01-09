package keyboard;

import actions.KeyDown;
import actions.KeyLeft;
import actions.KeyRight;
import actions.KeyUp;
import java.awt.event.KeyEvent;
import manager.SnakeManager;

/**
 *
 * @author Tom�
 */
public class Arrows implements IKeyboard {

    @Override
    public boolean isKeyPressed(int key, SnakeManager manager) {
        switch (key) {
            case KeyEvent.VK_UP:
                new KeyUp(manager).execute();
                return true;
            case KeyEvent.VK_DOWN:
                new KeyDown(manager).execute();
                return true;
            case KeyEvent.VK_LEFT:
                new KeyLeft(manager).execute();
                return true;
            case KeyEvent.VK_RIGHT:
                new KeyRight(manager).execute();
                return true;
            default:
                return false;
        }
    }

}
