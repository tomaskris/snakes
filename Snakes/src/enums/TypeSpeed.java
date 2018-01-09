package enums;

/**
 *
 * @author Tom�
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
