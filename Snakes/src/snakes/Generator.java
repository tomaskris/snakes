/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.util.Random;
import static snakes.Constants.MAX_HEIGHT_GAME_BOARD;
import static snakes.Constants.MAX_WIDTH_GAME_BOARD;
import static snakes.Constants.SIZE_IN_PIXEL;

/**
 *
 * @author Tomy
 */
//SINGLETON
public class Generator {

    private static Generator instance = new Generator();

    private Random randCoordinate;
    private Random randItem;
    private Random randColor;

    private Generator() {
        Random randSeed = new Random();
        this.randCoordinate = new Random(randSeed.nextInt());
        this.randItem = new Random(randSeed.nextInt());
        this.randColor = new Random(randSeed.nextInt());
    }

    public Position getRandCoordinate() {
        int tmp, x, y;
        tmp = randCoordinate.nextInt(MAX_WIDTH_GAME_BOARD / SIZE_IN_PIXEL);
        x = (tmp * SIZE_IN_PIXEL);
        tmp = randCoordinate.nextInt(MAX_HEIGHT_GAME_BOARD / SIZE_IN_PIXEL);
        y = (tmp * SIZE_IN_PIXEL);
        return new Position(x, y);
    }

    public static Generator getInstance() {
        return instance;
    }

}
