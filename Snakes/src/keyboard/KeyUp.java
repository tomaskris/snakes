package keyboard;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class KeyUp extends KeyCommand {

    public KeyUp(SnakeManager manager, int key) {
        super(manager, key);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.DOWN) {
            getSnake().moveUp();
        }
    }

}
