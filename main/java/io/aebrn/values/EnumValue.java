package io.aebrn.values;

/**
 * @author aebrn
 * 12/5/2020
 */
public final class EnumValue<T extends Enum> extends Value<T> {
    private Enum[] values;

    private EnumValue(String label, T value) {
        super(label, value);
    }

    public EnumValue(String label, T value, Enum[] values) {
        this(label, value);
        this.values = values;
    }

    @Override
    public void setValue(Enum value) {
        for (Enum enumValue : values) {
            if (enumValue == value) {
                super.setValue((T) enumValue);
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
