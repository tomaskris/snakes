/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Univerzální herní objekt
 * @author Fugiczek
 * @version 1.1
 */
public class GObject {

    /**
     * x-ová souøadnice
     */
    private int x;
    /**
     * y-ová souøadnice
     */
    private int y;
    /**
     * velikost v pixelech pøi vykreslení
     */
    private int sizeInPX;
    /**
     * barva objektu (na vykreslení)
     */
    private Color color;

    /**
     * Konstruktor na vytvoøení
     *
     * @param x x-ová souøadnice
     * @param y y-ová souøadnice
     * @param sizeInPX velikost v pixelech pøi vykreslení
     * @param color barva objektu (na vykreslení)
     */
    public GObject(int x, int y, int sizeInPX, Color color) {
        setX(x);
        setY(y);
        setSizeInPX(sizeInPX);
        setColor(color);
    }

    /**
     * Vykreslení objektu
     *
     * @param g2 instance tøídy Graphics2D na vykreslení
     */
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x, y, sizeInPX, sizeInPX);
    }

    /**
     * @return x-ová souøadnice
     */
    public int getX() {
        return x;
    }

    /**
     * @param x nová x-ová souøadnice
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y-ová souøadnice
     */
    public int getY() {
        return y;
    }

    /**
     * @param y nová y-ová souøadnice
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
     * @param sizeInPX nová velikost v PX
     */
    public void setSizeInPX(int sizeInPX) {
        this.sizeInPX = sizeInPX;
    }

    /**
     * @return barva pro vykreslení
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color nová barva pro vykreslní
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
