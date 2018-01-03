/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collisions;

import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import field.food.Food;
import field.snake.Head;
import java.util.List;
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
        for (IFieldState drawFood : drawFoods) {
            if (snake.get(0).getPosition().getX() == drawFood.getPosition().getX() && snake.get(0).getPosition().getY() == drawFood.getPosition().getY()) {
                score = ((Food)drawFood.getField()).getScore();
                drawFoods.set(drawFoods.indexOf(drawFood), null);
                return score;
            }
        }
        return score;
    }

}
