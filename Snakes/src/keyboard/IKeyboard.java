package keyboard;

import manager.SnakeManager;

/**
 *
 * @author Tom�
 */
public interface IKeyboard {
    
    // TODO template method
    public boolean isKeyPressed(int key, SnakeManager manager);
    
}
