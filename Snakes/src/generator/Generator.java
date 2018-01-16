package generator;

import java.util.List;
import java.util.Random;
import field.Position;
import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import static constants.Constants.SIZE_IN_PIXEL;
import field.Field;
import field.food.Food;
import field.snake.Snake;
import states.FieldDown;
import states.FieldLeft;
import states.FieldRight;
import states.FieldUp;
import states.IFieldState;

/**
 * Singleton design pattern
 *
 * @author Tomáš
 */
public class Generator {

    private static Generator instance = new Generator();

    private Random randCoordinate;
    private Random randEat;
    private Random randColor;
    private Random randStateSnake;
    private Random randStateFood;

    /**
     * Private constructor
     */
    private Generator() {
        Random randSeed = new Random();
        this.randCoordinate = new Random(randSeed.nextInt());
        this.randEat = new Random(randSeed.nextInt());
        this.randColor = new Random(randSeed.nextInt());
        this.randStateSnake = new Random(randSeed.nextInt());
        this.randStateFood = new Random(randSeed.nextInt());
    }

    public Position getRandCoordinate() {
        int tmp, x, y;
        tmp = randCoordinate.nextInt(MAX_WIDTH_GAME_BOARD / SIZE_IN_PIXEL);
        x = 10 + (tmp * SIZE_IN_PIXEL);
        tmp = randCoordinate.nextInt(MAX_HEIGHT_GAME_BOARD / SIZE_IN_PIXEL);
        y = 30 + (tmp * SIZE_IN_PIXEL);
        return new Position(x, y);
    }

    /**
     * Prototype design pattern
     *
     * @param list
     * @return
     */
    public Field getRandFood(List<Field> list) {
        Food food = ((Food) list.get(randEat.nextInt(list.size()))).copy();
        food.changePosition(getRandCoordinate());
        return food;
    }

    public IFieldState getRandStateFood() {
        return getRandState(randStateFood);
    }

    public Field getSnake() {
        return new Snake(getRandState(randStateSnake));
    }

    private IFieldState getRandState(Random randStateFood) {
        switch (randStateFood.nextInt(4)) {
            case 0:
                return new FieldDown(getRandCoordinate());
            case 1:
                return new FieldUp(getRandCoordinate());
            case 2:
                return new FieldLeft(getRandCoordinate());
            case 3:
                return new FieldRight(getRandCoordinate());
            default:
                return null;
        }
    }

    public static Generator getInstance() {
        return instance;
    }

}
