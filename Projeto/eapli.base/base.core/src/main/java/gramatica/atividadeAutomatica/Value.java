package gramatica.atividadeAutomatica;

import org.w3c.dom.Node;

public class Value {

    public static Value VOID = new Value(new Object());

    final Object value;

    public Value(Object value) {
        this.value = value;
    }

    public Boolean asBoolean() {
        return Boolean.parseBoolean(value.toString());
    }

    public Double asDouble() {
        return Double.parseDouble(value.toString());
    }

    public int asInteger() {
        return Integer.parseInt(value.toString());
    }

    public String asString() {
        return String.valueOf(value);
    }

    public boolean isDouble() {
        return value instanceof Double;
    }

    public boolean isInteger() {
        return value instanceof Integer;
    }

    public boolean isString() {
        return value instanceof String;
    }

    public boolean isNode() {
        return value instanceof Node;
    }

    @Override
    public int hashCode() {

        if (value == null) {
            return 0;
        }

        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (value == o) {
            return true;
        }

        if (value == null || o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Value that = (Value) o;

        return this.value.equals(that.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}