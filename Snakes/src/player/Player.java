package player;

import keyboard.Keyboard;
import manager.SnakeManager;

/**
 *
 * @author Tomáš
 */
public class Player {

    private String name; //meno hraca
    private int score; //ziskane skore hraca
    private Keyboard keyboard; //typ tlacitok na klavesnici, na ktorych hra
    private SnakeManager snakeManager;
    
    public Player(String name, Keyboard keyboard, SnakeManager snakeManager) {
        this.name = name;
        this.score = 0;
        this.keyboard = keyboard;
        this.snakeManager = snakeManager;
    }

    public void increaseScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getName() {
        return name;
    }

    public SnakeManager getSnakeManager() {
        return snakeManager;
    }
    
}
