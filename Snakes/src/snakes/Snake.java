/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Had se všemi jeho vlastnostmi
 *
 * @author Fugiczek
 * @version 1.1
 */
public class Snake extends GObject {

    /**
     * List s hadovými èástmi tìla
     */
    private List<GObject> body;
    /**
     * Barva tìla hada
     */
    private Color colorBody;
    /**
     * Smìr kudy had jde
     */
    private Direction direct;

    /**
     * Konstruktor na vytvoøení
     *
     * @param x x-ová souøadnice
     * @param y y-ová souøadnice
     * @param sizeInPX velikost v pixelech pøi vykreslení
     * @param color barva hlavy (na vykreslení)
     * @param colorBody barva tìla (na vykreslení)
     */
    public Snake(int x, int y, int sizeInPX, Color color, Color colorBody) {
        super(x, y, sizeInPX, color);
        body = new ArrayList<>();
        setColorBody(colorBody);
        setDirect(Direction.DOWN);
    }

    /**
     * Pøepsaná tøída na vykreslení, vykresluje hlavu a tìlo dohromady
     */
    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        g2.fillRect(getX(), getY(), getSizeInPX(), getSizeInPX());

        for (GObject ob : body) {
            ob.draw(g2);
        }
    }

    /**
     * @return barva tìla
     */
    public Color getColorBody() {
        return colorBody;
    }

    /**
     * @param colorBody nová barva tìla
     */
    public void setColorBody(Color colorBody) {
        this.colorBody = colorBody;
    }

    /**
     * @return smìr hada
     */
    public Direction getDirect() {
        return direct;
    }

    /**
     * @param direct nový smìr hada
     */
    public void setDirect(Direction direct) {
        this.direct = direct;
    }

    /**
     * Rozšíøí tìlo hada o jednu novou èást, dá ji na místo hlavy a hlavu posune
     */
    public void expandBody() {
        body.add(0, new GObject(getX(), getY(), getSizeInPX(), getColorBody()));
        moveHead();
    }

    /**
     * @return list s tìlem
     */
    public List<GObject> getBody() {
        return body;
    }

    /**
     * Pohne s celým tìlem vèetnì hlavy
     */
    public void move() {
        moveBody(); // první musí být pohyb tìla protože vychází ze souøadnic hlavy
        moveHead();
    }

    /**
     * Pohyb hlavy v závislosti na smìru
     */
    private void moveHead() {
        switch (getDirect()) {
            case LEFT:
                setX(getX() - getSizeInPX());
                break;
            case RIGHT:
                setX(getX() + getSizeInPX());
                break;
            case UP:
                setY(getY() - getSizeInPX());
                break;
            case DOWN:
                setY(getY() + getSizeInPX());
                break;
        }
    }

    /**
     * Posouvá tìlem na základì souøadnic minulé èásti
     */
    private void moveBody() {
        int tmpX = getX(), tmpY = getY(), tmp; // pomocné promìnné

        for (GObject obj : body) {
            tmp = obj.getX();
            obj.setX(tmpX);
            tmpX = tmp;
            tmp = obj.getY();
            obj.setY(tmpY);
            tmpY = tmp;
        }

    }
}
