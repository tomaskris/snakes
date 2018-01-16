package keyboard;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tom�
 */
public class KeyRight extends KeyCommand {

    public KeyRight(SnakeManager manager, int key) {
        super(manager, key);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.LEFT) {
            getSnake().turnRight();
        }
    }

}
