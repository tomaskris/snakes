/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import manager.SnakeManager;

/**
 *
 * @author Tomy
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
