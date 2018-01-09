package actions;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class KeyUp extends ASnakeAction {

    public KeyUp(SnakeManager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.DOWN) {
            getSnake().moveUp();
        }
    }

}
