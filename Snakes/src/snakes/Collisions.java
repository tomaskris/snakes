/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

/**
 * T��da obsahuje metody na kontroly r�zn�ch koliz�.
 *
 * @author Fugiczek
 * @version 1.1
 */
public class Collisions {

    private Collisions() {
    } //nepot�ebujeme aby se vytv��eli instance, proto priv�tn� konstruktor

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
     * @return Vrac� true, kdy� se sou�adnice hlavy hada a bonusu rovnaj�. Vrac�
     * false, kdy� ne.
     */
    public static boolean checkBonus(Snake snake, AItem bonus) {
        if (snake.getX() == bonus.getPosition().getX() && snake.getY() == bonus.getPosition().getY()) {
            return true;
        } else {
            return false;
        }
    }

}
