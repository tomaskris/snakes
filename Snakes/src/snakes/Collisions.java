/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

/**
 * T��da obsahuje metody na kontroly r�zn�ch koliz�.
 *
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
        for (SnakeBody obj : snake.getBody()) {
            if ((snake.getPosition().getX() == obj.getPosition().getX())
                    && (snake.getPosition().getY() == obj.getPosition().getY())) {
                return true;
            }
        }

        if (snake.getPosition().getX() < 0) {
            return true;
        }
        if (snake.getPosition().getX() >= maxX) {
            return true;
        }
        if (snake.getPosition().getY() < 0) {
            return true;
        }
        if (snake.getPosition().getY() >= maxY) {
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
        if (snake.getPosition().getX() == bonus.getPosition().getX() && snake.getPosition().getY() == bonus.getPosition().getY()) {
            return true;
        } else {
            return false;
        }
    }

}
