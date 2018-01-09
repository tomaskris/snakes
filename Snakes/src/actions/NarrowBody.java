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
public class NarrowBody extends ASnakeAction {

    public NarrowBody(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        getSnake().narrowBody();
    }
    
}
