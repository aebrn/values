package io.aebrn.values;

/**
 * @author aebrn
 * 12/5/2020
 */
public final class EnumValue<T extends Enum<T>> extends Value<T> {
    private final T[] values;

    public EnumValue(String label, T value, T[] values) {
        super(label, value);
        this.values = values;
    }

    @Override
    public void setValue(T value) {
        for (T enumValue : values) {
            if (enumValue.equals(value)) {
                super.setValue(enumValue);
                break;
            }
        }
    }

    public void increment() {
        this.setValue(values[getValue().ordinal()] == values[values.length - 1] ?
                values[0] : values[getValue().ordinal() + 1]);
    }

    public void decrement() {
        this.setValue(values[getValue().ordinal()] != values[0] ?
                values[getValue().ordinal() - 1] : values[values.length - 1]);
    }
}
