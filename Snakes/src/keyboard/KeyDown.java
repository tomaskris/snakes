package keyboard;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class KeyDown extends KeyCommand {

    public KeyDown(SnakeManager manager, int key) {
        super(manager, key);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.UP) {
            getSnake().moveDown();
        }
    }

}
