package pw.highimhell.values;

/**
 * @author hell
 * 12/4/2020
 */
public class Value<T> {
    private final String label;
    private T value;
    private final T originalValue;

    public Value(String label, T value) {
        this.label = label;
        this.originalValue = this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void reset() {
        this.value = originalValue;
    }

    public T getOriginalValue() {
        return originalValue;
    }
}
