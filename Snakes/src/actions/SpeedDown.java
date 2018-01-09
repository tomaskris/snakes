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
public class SpeedDown extends ASnakeAction {

    public SpeedDown(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        getSnake().slowSpeed();
    }

}
