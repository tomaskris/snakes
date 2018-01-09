package enums;

/**
 *
 * @author Tomáš
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

    public static TypeSnake fromString(String text) {
        for (TypeSnake b : TypeSnake.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}
