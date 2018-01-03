/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Tomy
 */
public enum TypeSnake {
    YELLOW_SNAKE("yellow"), BROWN_SNAKE("brown"), GREEN_SNAKE("green"), RED_SNAKE("red");
    
    private String name;

    private TypeSnake(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
