package actions;

import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class SpeedUp extends ASnakeAction {

    public SpeedUp(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        getSnake().fastSpeed();
    }

}
