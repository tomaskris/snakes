/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import enums.TypeDirection;
import manager.SnakeManager;

/**
 *
 * @author Tomy
 */
public class KeyRight extends ASnakeAction {

    public KeyRight(SnakeManager snake) {
        super(snake);
    }

    @Override
    public void execute() {
        if (getSnake().getDrawField().get(0).getDirection() != TypeDirection.LEFT) {
            getSnake().turnRight();
        }
    }

}