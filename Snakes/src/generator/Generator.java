/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.util.List;
import java.util.Random;
import snakes.Position;
import static constants.Constants.MAX_HEIGHT_GAME_BOARD;
import static constants.Constants.MAX_WIDTH_GAME_BOARD;
import static constants.Constants.SIZE_IN_PIXEL;
import field.Field;

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

    private Generator() {
        Random randSeed = new Random();
        this.randCoordinate = new Random(randSeed.nextInt());
        this.randEat = new Random(randSeed.nextInt());
        this.randColor = new Random(randSeed.nextInt());
    }

    public Position getRandCoordinate() {
        int tmp, x, y;
        tmp = randCoordinate.nextInt(MAX_WIDTH_GAME_BOARD / SIZE_IN_PIXEL);
        x = 10 + (tmp * SIZE_IN_PIXEL);
        tmp = randCoordinate.nextInt(MAX_HEIGHT_GAME_BOARD / SIZE_IN_PIXEL);
        y = 30 + (tmp * SIZE_IN_PIXEL);
        return new Position(x, y);
    }
    
    public Field getRandEat(List<Field> list) {
        return list.get(randEat.nextInt(list.size()));
    }

    public static Generator getInstance() {
        return instance;
    }

}
