package actions;

import manager.SnakeManager;

/**
 *
 * @author Tom�
 */
public class SpeedDown extends ASnakeAction {

    public SpeedDown(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        getSnake().slowSpeed();
    }

}
