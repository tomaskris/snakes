package player;

import enums.TypeSnake;
import keyboard.IKeyboard;

/**
 *
 * @author Tomáš
 */
public class Player {

    private String name; //meno hraca
    private int score; //ziskane skore hraca
    private TypeSnake typeSnake; //typ hada
    private IKeyboard keyboard; //typ tlacitok na klavesnici, na ktorych hra

    public Player(String name, TypeSnake typeSnake, IKeyboard keyboard) {
        this.name = name;
        this.score = 0;
        this.typeSnake = typeSnake;
        this.keyboard = keyboard;
    }

    public void increaseScore(int points) {
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

    public String getName() {
        return name;
    }

}
