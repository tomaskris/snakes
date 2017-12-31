/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field;

import snakestate.SnakeBody;
import field.Field;
import manager.FoodManager;
import manager.Manager;
import snakes.Snake;

/**
 * Trieda obsahuje metody na kontroly roznych kolizii.
 *
 * @author Tomy
 */
//SINGLETON
public class Collisions {

    private Collisions() {
    }

    /**
     * Metoda zji��uje jestli had nezajel mimo hrac� pole, nebo nenarazil s�m do
     * sebe.
     *
     * @param snake instance t��dy Snake
     * @param maxX Maxim�ln� ���ka hrac�ho pole
     * @param maxY Maxim�ln� v��ka hrac�ho pole
     * @return Vrac� true jestli se sou�adnice jeho hlavy rovnaj� n�jak�m
     * sou�adnic�m jeho t�la. D�le vrac� true jestli sou�adnice jeho hlavy jsou
     * mimo hern� pole. Pokud se ��dn� z t�chto podm�nek nepotvrd�, vrac� false.
     */
    public static boolean checkCollision(Snake snake, int maxX, int maxY) {
        for (SnakeBody obj : snake.getBody()) {
            if ((snake.getPosition().getX() == obj.getPosition().getX())
                    && (snake.getPosition().getY() == obj.getPosition().getY())) {
                return true;
            }
        }

        if (snake.getPosition().getX() < 10) {
            return true;
        }
        if (snake.getPosition().getX() >= maxX + 20) {
            return true;
        }
        if (snake.getPosition().getY() < 30) {
            return true;
        }
        if (snake.getPosition().getY() >= maxY + 40) {
            return true;
        }

        return false;
    }

    /**
     * Kontroluje, ci had zjedol jedlo
     *
     */
    public static boolean checkEatenFood(Snake snake, Manager manager) {
        FoodManager man = (FoodManager)manager;
        for (int i = 0; i < man.getDrawFoods().length; i++) {
            if (snake.getPosition().getX() == man.getDrawFoods()[i].getPosition().getX() && snake.getPosition().getY() == man.getDrawFoods()[i].getPosition().getY()) {
                man.getDrawFoods()[i] = null;
                return true;
            }
        }
        return false;
    }

}
