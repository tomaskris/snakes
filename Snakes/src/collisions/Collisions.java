/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisions;

import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import field.food.Food;
import java.util.List;
import manager.Manager;
import manager.SnakeManager;
import states.IFieldState;

/**
 * Trieda obsahuje metody na kontroly roznych kolizii.
 *
 * @author Tomy
 */
//SINGLETON
public class Collisions {

    private Collisions() {
    }

    public static boolean checkCollision(List<IFieldState> snake) {
        IFieldState head = snake.get(0);
        IFieldState snakePart = null;
        for (int i = 1; i < snake.size(); i++) {
            snakePart = snake.get(i);
            if ((head.getPosition().getX() == snakePart.getPosition().getX())
                    && (head.getPosition().getY() == snakePart.getPosition().getY())) {
                return true;
            }
        }

        if (head.getPosition().getX() < 10) {
            return true;
        }
        if (head.getPosition().getX() >= MAX_WIDTH_GAME_BOARD + 20) {
            return true;
        }
        if (head.getPosition().getY() < 30) {
            return true;
        }
        if (head.getPosition().getY() >= MAX_HEIGHT_GAME_BOARD + 40) {
            return true;
        }
        return false;
    }

    public static int checkEatenFood(List<IFieldState> snake, List<IFieldState> drawFoods) {
        int score = 0;
        IFieldState head = snake.get(0);
        for (IFieldState drawFood : drawFoods) {
            if (drawFood != null) {
                if (head.getPosition().getX() == drawFood.getPosition().getX() && head.getPosition().getY() == drawFood.getPosition().getY()) {
                    score = ((Food) drawFood.getField()).getScore();
                    drawFoods.set(drawFoods.indexOf(drawFood), null);
                    return score;
                }
            }
        }
        return score;
    }

    public static boolean checkSnakesCollision(Manager curPlayer, List<Manager> players) {
        IFieldState head = curPlayer.getDrawField().get(0);
        for (Manager manager : players) {
            if (!curPlayer.equals(manager) && ((SnakeManager)manager).isLive()) {
                for (IFieldState snakeBody : manager.getDrawField()) {
                    if (head.getPosition().getX() == snakeBody.getPosition().getX() && head.getPosition().getY() == snakeBody.getPosition().getY()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
