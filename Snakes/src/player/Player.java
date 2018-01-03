/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import enums.TypeSnake;
import keyboard.IKeyboard;

/**
 *
 * @author Tomy
 */
public class Player {
    
    private String name; //meno hraca
    private int score; //ziskane skore hraca
    private TypeSnake typeSnake; //typ hada
//    private TypeKeyboard keyboard; //typ tlacitok na klavesnici, na ktorych hra
    private IKeyboard keyboard;

    public Player(String name, TypeSnake typeSnake, IKeyboard keyboard) {
        this.name = name;
        this.score = 0;
        this.typeSnake = typeSnake;
        this.keyboard = keyboard;
    }
    
    public void increaseScore(int points){
        score += points;
    }

    public int getScore() {
        return score;
    }

    public IKeyboard getKeyboard() {
        return keyboard;
    }

    public TypeSnake getTypeSnake() {
        return typeSnake;
    }
    
    
    
}
