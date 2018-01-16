package collisions;

import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import field.Field;
import field.food.Food;
import java.util.List;
import manager.Manager;
import manager.SnakeManager;
import player.Player;
import states.IFieldState;

/**
 * Trieda obsahuje metody na kontroly roznych kolizii.
 *
 * @author Tomáš
 */
//SINGLETON
public class Collisions {

    private Collisions() {
    }

    public static boolean checkCollision(List<Field> snake) {
        Field head = snake.get(0);
        Field snakePart = null;
        for (int i = 1; i < snake.size(); i++) {
            snakePart = snake.get(i);
            if (collides(head, snakePart)) {
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

    public static Food checkEatenFood(List<Field> snake, List<Field> foods) {
        Field head = snake.get(0);
        for (Field foodField : foods) {
            if (foodField != null) {
                if (collides(head, foodField)) {
                    Food food = (Food) foodField;

                    foods.set(foods.indexOf(foodField), null);
                    return food;
                }
            }
        }
        return null;
    }

    private static boolean collides(Field first, Field second) {
        return first.getPosition().getX() == second.getPosition().getX()
                && first.getPosition().getY() == second.getPosition().getY();
    }

    public static boolean checkSnakesCollision(Manager curPlayer, List<Player> players) {
        Field head = curPlayer.getDrawField().get(0);
        for (Player player : players) {
            SnakeManager manager = player.getSnakeManager();
            if (!curPlayer.equals(manager) && manager.isLive()) {
                for (Field snakeBody : manager.getDrawField()) {
                    if (collides(head, snakeBody)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
