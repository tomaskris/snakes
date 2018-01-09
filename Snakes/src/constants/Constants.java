package constants;

/**
 *
 * @author Tom�
 */
public class Constants {
    //max sirka herneho platna
    public static final int MAX_WIDTH_GAME_BOARD = 400;
    //max vyska herneho platna
    public static final int MAX_HEIGHT_GAME_BOARD = 300;
    //max sirka herneho platna
    public static final int MAX_WIDTH_WINDOW = 430;
    //max vyska herneho platna
    public static final int MAX_HEIGHT_WINDOW = 350;
    //velkost itemu v pixeloch
    public static final int SIZE_IN_PIXEL = 10;
    //pocet jedla, ktore sa zobrazuje na hracej ploche
    public static final int NUMBER_OF_FOODS = 3;
    //FPS (1000/FRAME_DELAY), ovplyvnuje rychlost hry
    public static final int FRAME_DELAY = 50;
    
    //rychla rychlost hada
    public static final int FAST_SPEED = 1;
    //konstantna rychlost hada
    public static final int CONSTANT_SPEED = 2;
    //pomala rychlost hada
    public static final int SLOW_SPEED = 3;
    
    //image pre jablko
    private static final String IMAGE_FOOD_DIR = "/images/foods/";
    public static final String IMAGE_APPLE = IMAGE_FOOD_DIR + "apple.png";
    public static final String IMAGE_CARROT = IMAGE_FOOD_DIR + "carrot.png";
    public static final String IMAGE_CHERRY = IMAGE_FOOD_DIR + "cherry.png";
    public static final String IMAGE_CORN = IMAGE_FOOD_DIR + "corn.png";
    public static final String IMAGE_GRAPES = IMAGE_FOOD_DIR + "grapes.png";
    public static final String IMAGE_LEMON = IMAGE_FOOD_DIR + "lemon.png";
    public static final String IMAGE_MELON = IMAGE_FOOD_DIR + "melon.png";
    public static final String IMAGE_MUSHROOMS = IMAGE_FOOD_DIR + "mushrooms.png";
    public static final String IMAGE_PINEAPPLE = IMAGE_FOOD_DIR + "pineapple.png";
    public static final String IMAGE_STRAWBERRY = IMAGE_FOOD_DIR + "strawberry.png";
    
}
