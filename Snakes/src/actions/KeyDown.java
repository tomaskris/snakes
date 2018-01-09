package actions;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class KeyDown extends ASnakeAction {

    public KeyDown(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.UP) {
            getSnake().moveDown();
        }
    }

}
