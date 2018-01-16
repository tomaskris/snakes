package manager;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import static constants.Constants.NUMBER_OF_FOODS;
import field.Field;
import field.food.*;

/**
 *
 * @author Tomáš
 */
public class FoodManager extends Manager {

    private List<Field> foods; //jedenie, z ktorych sa nahodne vybera

    public FoodManager(Graphics2D graphics) {
        super(graphics);
        foods = new ArrayList<>();
        //jedla, ktore sa vykresluju na plochu
        drawField = new ArrayList<>(NUMBER_OF_FOODS);
        loadFoods();
    }

    private void registerFood(Field food) {
        foods.add(food);
    }

    private Field randomFood() {
        return getGenerator().getRandFood(foods);
    }

    private void loadFoods() {
        registerFood(new Apple());
        registerFood(new Carrot());
        registerFood(new Cherry());
        registerFood(new Corn());
        registerFood(new Grapes());
        registerFood(new Lemon());
        registerFood(new Melon());
        registerFood(new Mushrooms());
        registerFood(new Pineapple());
        registerFood(new Strawberry());

        for (int i = 0; i < NUMBER_OF_FOODS; i++) {
            drawField.add(randomFood());
        }
    }

    @Override
    public void draw() {
        for (Field drawFood : drawField) {
            if (drawFood == null) {
                drawField.set(drawField.indexOf(drawFood), randomFood());
            } else {
                drawFood.draw(getGraphics());
            }
        }
    }

    @Override
    public void move() {
        // TODO
        //ak je jedlo pohybujuce sa, tak sa bude pohybovat
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void turnLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void turnRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
