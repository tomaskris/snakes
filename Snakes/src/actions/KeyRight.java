package actions;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class KeyRight extends ASnakeAction {

    public KeyRight(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.LEFT) {
            getSnake().turnRight();
        }
    }

}
