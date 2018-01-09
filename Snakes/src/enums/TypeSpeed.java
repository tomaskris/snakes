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
public enum TypeSpeed {
    FAST(1), NORMAL(2), SLOW(3);
    
    private int value;

    private TypeSpeed(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
