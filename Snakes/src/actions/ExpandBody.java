package actions;

import manager.SnakeManager;

/**
 *
 * @author Tomáš
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
