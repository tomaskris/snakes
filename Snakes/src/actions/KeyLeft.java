package actions;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class KeyLeft extends ASnakeAction {

    public KeyLeft(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.RIGHT) {
            getSnake().turnLeft();
        }
    }

}
