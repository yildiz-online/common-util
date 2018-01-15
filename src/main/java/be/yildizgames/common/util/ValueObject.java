package be.yildizgames.common.util;

/**
 * @author Grégory Van den Borre
 */
public class ValueObject {

    /**
     * Value.
     */
    public final int value;

    protected ValueObject(int value) {
        this.value = value;
    }

    @Override
    public final boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && value == ((ValueObject) o).value;
    }

    @Override
    public final int hashCode() {
        return value;
    }

    @Override
    public final String toString() {
        return String.valueOf(this.value);
    }
}
