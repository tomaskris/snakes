/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Tomy
 */
//SINGLETON
public class Generator {

    private static Generator instance = new Generator();

    private Random randCoordinate;
    private Random randEat;
    private Random randColor;
    private Random randStateSnake;
    private Random randStateFood;

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

    public IFieldState getRandFood(List<Field> list) {
        Food food = ((Food)list.get(randEat.nextInt(list.size()))).copy();
        food.changePosition(getRandCoordinate());
        return getRandStateFood(food);
    }
    
    public IFieldState getRandFood(Field food) {
        return getRandStateFood(food);
    }
    
    private IFieldState getRandStateFood(Field field){
        return getRandState(randStateFood, field);
    }
    
    public IFieldState getRandSnake() {
        Snake head = new Snake();
        head.changePosition(new Position(100, 100));
        head.changePosition(getRandCoordinate());
        return getRandState(randStateSnake, head);
    }
    
    private IFieldState getRandState(Random randStateFood, Field field){
        switch (randStateFood.nextInt(4)) {
            case 0:
                return new FieldDown(field);
            case 1:
                return new FieldUp(field);
            case 2:
                return new FieldLeft(field);
            case 3:
                return new FieldRight(field);
            default:
                return null;
        }
    }

    public static Generator getInstance() {
        return instance;
    }

}
