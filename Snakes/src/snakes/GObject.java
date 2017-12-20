/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Univerz�ln� hern� objekt
 * @author Fugiczek
 * @version 1.1
 */
public class GObject {

    /**
     * x-ov� sou�adnice
     */
    private int x;
    /**
     * y-ov� sou�adnice
     */
    private int y;
    /**
     * velikost v pixelech p�i vykreslen�
     */
    private int sizeInPX;
    /**
     * barva objektu (na vykreslen�)
     */
    private Color color;

    /**
     * Konstruktor na vytvo�en�
     *
     * @param x x-ov� sou�adnice
     * @param y y-ov� sou�adnice
     * @param sizeInPX velikost v pixelech p�i vykreslen�
     * @param color barva objektu (na vykreslen�)
     */
    public GObject(int x, int y, int sizeInPX, Color color) {
        setX(x);
        setY(y);
        setSizeInPX(sizeInPX);
        setColor(color);
    }

    /**
     * Vykreslen� objektu
     *
     * @param g2 instance t��dy Graphics2D na vykreslen�
     */
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x, y, sizeInPX, sizeInPX);
    }

    /**
     * @return x-ov� sou�adnice
     */
    public int getX() {
        return x;
    }

    /**
     * @param x nov� x-ov� sou�adnice
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y-ov� sou�adnice
     */
    public int getY() {
        return y;
    }

    /**
     * @param y nov� y-ov� sou�adnice
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return velikost v PX
     */
    public int getSizeInPX() {
        return sizeInPX;
    }

    /**
     * @param sizeInPX nov� velikost v PX
     */
    public void setSizeInPX(int sizeInPX) {
        this.sizeInPX = sizeInPX;
    }

    /**
     * @return barva pro vykreslen�
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color nov� barva pro vykresln�
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
