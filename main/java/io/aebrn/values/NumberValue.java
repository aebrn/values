package io.aebrn.values;

/**
 * @author aebrn
 * 12/4/2020
 */
public final class NumberValue<T extends Number> extends Value<T> {
    private final T minimum, maximum;
    private final boolean shouldClamp;

    public NumberValue(String label, T value, T minimum, T maximum) {
        super(label, value);
        this.minimum = minimum;
        this.maximum = maximum;
        shouldClamp = true;
        setValue(value);
    }

    public NumberValue(String label, T value) {
        super(label, value);
        this.minimum = null;
        this.maximum = null;
        shouldClamp = false;
    }

    @Override
    public void setValue(T value) {
        super.setValue(shouldClamp ? ((Comparable) value).compareTo(minimum) < 0 ? minimum :
                (((Comparable) value).compareTo(maximum) > 0 ? maximum : value) : value);
    }

    public T getMinimum() {
        return minimum;
    }

    public T getMaximum() {
        return maximum;
    }
}
