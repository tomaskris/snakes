package actions;

import manager.SnakeManager;

/**
 *
 * @author Tom�
 */
abstract class ASnakeAction implements ISnakeAction {

    private SnakeManager snake;

    public ASnakeAction(SnakeManager snake) {
        this.snake = snake;
    }

    public SnakeManager getSnake() {
        return snake;
    }

}
