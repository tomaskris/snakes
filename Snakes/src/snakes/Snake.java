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
 * Had se v�emi jeho vlastnostmi
 *
 * @author Fugiczek
 * @version 1.1
 */
public class Snake extends GObject {

    /**
     * List s hadov�mi ��stmi t�la
     */
    private List<GObject> body;
    /**
     * Barva t�la hada
     */
    private Color colorBody;
    /**
     * Sm�r kudy had jde
     */
    private Direction direct;

    /**
     * Konstruktor na vytvo�en�
     *
     * @param x x-ov� sou�adnice
     * @param y y-ov� sou�adnice
     * @param sizeInPX velikost v pixelech p�i vykreslen�
     * @param color barva hlavy (na vykreslen�)
     * @param colorBody barva t�la (na vykreslen�)
     */
    public Snake(int x, int y, int sizeInPX, Color color, Color colorBody) {
        super(x, y, sizeInPX, color);
        body = new ArrayList<>();
        setColorBody(colorBody);
        setDirect(Direction.DOWN);
    }

    /**
     * P�epsan� t��da na vykreslen�, vykresluje hlavu a t�lo dohromady
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
     * @return barva t�la
     */
    public Color getColorBody() {
        return colorBody;
    }

    /**
     * @param colorBody nov� barva t�la
     */
    public void setColorBody(Color colorBody) {
        this.colorBody = colorBody;
    }

    /**
     * @return sm�r hada
     */
    public Direction getDirect() {
        return direct;
    }

    /**
     * @param direct nov� sm�r hada
     */
    public void setDirect(Direction direct) {
        this.direct = direct;
    }

    /**
     * Roz���� t�lo hada o jednu novou ��st, d� ji na m�sto hlavy a hlavu posune
     */
    public void expandBody() {
        body.add(0, new GObject(getX(), getY(), getSizeInPX(), getColorBody()));
        moveHead();
    }

    /**
     * @return list s t�lem
     */
    public List<GObject> getBody() {
        return body;
    }

    /**
     * Pohne s cel�m t�lem v�etn� hlavy
     */
    public void move() {
        moveBody(); // prvn� mus� b�t pohyb t�la proto�e vych�z� ze sou�adnic hlavy
        moveHead();
    }

    /**
     * Pohyb hlavy v z�vislosti na sm�ru
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
     * Posouv� t�lem na z�klad� sou�adnic minul� ��sti
     */
    private void moveBody() {
        int tmpX = getX(), tmpY = getY(), tmp; // pomocn� prom�nn�

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
