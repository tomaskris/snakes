package keyboard;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class KeyLeft extends KeyCommand {

    public KeyLeft(SnakeManager manager, int key) {
        super(manager, key);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.RIGHT) {
            getSnake().turnLeft();
        }
    }

}
