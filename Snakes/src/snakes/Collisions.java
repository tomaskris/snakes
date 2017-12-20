/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

/**
 * Tøída obsahuje metody na kontroly rùznıch kolizí.
 *
 * @author Fugiczek
 * @version 1.1
 */
public class Collisions {

    private Collisions() {
    } //nepotøebujeme aby se vytváøeli instance, proto privátní konstruktor

    /**
     * Metoda zjišuje jestli had nezajel mimo hrací pole, nebo nenarazil sám do
     * sebe.
     *
     * @param snake instance tøídy Snake
     * @param maxX Maximální šíøka hracího pole
     * @param maxY Maximální vıška hracího pole
     * @return Vrací true jestli se souøadnice jeho hlavy rovnají nìjakım
     * souøadnicím jeho tìla. Dále vrací true jestli souøadnice jeho hlavy jsou
     * mimo herní pole. Pokud se ádná z tìchto podmínek nepotvrdí, vrací false.
     */
    public static boolean checkCollision(Snake snake, int maxX, int maxY) {
        for (GObject obj : snake.getBody()) {
            if ((snake.getX() == obj.getX()) && (snake.getY() == obj.getY())) {
                return true;
            }
        }

        if (snake.getX() < 0) {
            return true;
        }
        if (snake.getX() >= maxX) {
            return true;
        }
        if (snake.getY() < 0) {
            return true;
        }
        if (snake.getY() >= maxY) {
            return true;
        }

        return false;
    }

    /**
     * Kontroluje zda had najel na bonus
     *
     * @param snake Objekt hada
     * @param bonus Objekt bonusu
     * @return Vrací true, kdy se souøadnice hlavy hada a bonusu rovnají. Vrací
     * false, kdy ne.
     */
    public static boolean checkBonus(Snake snake, AItem bonus) {
        if (snake.getX() == bonus.getPosition().getX() && snake.getY() == bonus.getPosition().getY()) {
            return true;
        } else {
            return false;
        }
    }

}
