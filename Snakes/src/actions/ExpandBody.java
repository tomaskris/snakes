package actions;

import manager.SnakeManager;

/**
 *
 * @author Tom�
 */
public class ExpandBody extends ASnakeAction {

    public ExpandBody(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        getSnake().expandBody();
    }

}
