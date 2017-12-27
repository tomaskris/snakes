/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Tomy
 */
public class ItemManager {

    private List<AItem> list;
    private Random randItem;

    public ItemManager() {
        this.list = new LinkedList<>();
        this.randItem = new Random();
    }

    private void registerItem(AItem item) {
        list.add(item);
    }

    private AItem getItemByID(int IDItem) {
        return list.get(IDItem).clone();
    }

    public AItem getRandomItem() {
        AItem item = getItemByID(randItem.nextInt(list.size()));
        item.locateItem();
        return item;
    }

    public void loadItems() {
        registerItem(new Apple(Color.red));
        registerItem(new Apple(Color.green));
        registerItem(new Apple(Color.yellow));
        
        //toto prerobit, ze parameter bude pocet itemov
        //a bude cyklus, ktory bude nahodne vyrabat itemy roznych farieb?
    }

}
