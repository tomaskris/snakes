package keyboard;

import actions.KeyDown;
import actions.KeyLeft;
import actions.KeyRight;
import actions.KeyUp;
import java.awt.event.KeyEvent;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class WASD implements IKeyboard {

    @Override
    public boolean isKeyPressed(int key, SnakeManager manager) {
        switch (key) {
            case KeyEvent.VK_W:
                new KeyUp(manager).execute();
                return true;
            case KeyEvent.VK_A:
                new KeyLeft(manager).execute();
                return true;
            case KeyEvent.VK_S:
                new KeyDown(manager).execute();
                return true;
            case KeyEvent.VK_D:
                new KeyRight(manager).execute();
                return true;
            default: return false;
        }
    }

}
