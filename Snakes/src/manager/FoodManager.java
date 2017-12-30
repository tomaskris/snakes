/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import static constants.Constants.NUMBER_OF_FOODS;
import field.Field;
import field.food.*;

/**
 *
 * @author Tomy
 */
public class FoodManager extends Manager {

    private List<Field> foods; //jedenie, z ktorych sa nahodne vybera
    private Field[] drawFoods; //jedenie, ktore sa vykresluje na hraciu plochu

    public FoodManager(Graphics2D graphics) {
        super(graphics);
        this.foods = new ArrayList<>();
        this.drawFoods = new Field[NUMBER_OF_FOODS];
        loadFoods();
    }

    private void registerFood(Field food) {
        foods.add(food);
    }

    private Field randomFood() {
        return getGenerator().getRandEat(foods);
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
            drawFoods[i] = ((Food) randomFood()).copy();
            drawFoods[i].changePosition(getGenerator().getRandCoordinate());
        }
    }

    public Field[] getDrawFoods() {
        return drawFoods;
    }

    @Override
    public void draw() {
        for (int i = 0; i < NUMBER_OF_FOODS; i++) {
            if (drawFoods[i] == null) {
                drawFoods[i] = ((Food) randomFood()).copy();
                drawFoods[i].changePosition(getGenerator().getRandCoordinate());
                getGraphics().drawImage(drawFoods[i].getIcon().getImage(), drawFoods[i].getPosition().getX(), drawFoods[i].getPosition().getY(), null);
            } else {
                getGraphics().drawImage(drawFoods[i].getIcon().getImage(), drawFoods[i].getPosition().getX(), drawFoods[i].getPosition().getY(), null);
            }
        }
    }

}
