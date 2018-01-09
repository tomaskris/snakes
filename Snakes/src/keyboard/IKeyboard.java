package keyboard;

import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public interface IKeyboard {
    
    // TODO template method
    public boolean isKeyPressed(int key, SnakeManager manager);
    
}
