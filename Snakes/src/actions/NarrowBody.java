package actions;

import manager.SnakeManager;

/**
 *
 * @author Tom�
 */
public class NarrowBody extends ASnakeAction {

    public NarrowBody(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        getSnake().narrowBody();
    }

}
