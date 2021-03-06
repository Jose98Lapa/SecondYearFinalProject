package eapli.base.automatictask.executor;

import org.w3c.dom.Element;

public class Value {

    public static Value VOID = new Value(new Object());

    final Object value;
    String type;

    public Value(Object value) {
        this.value = value;
    }

    public void type(String t) {
        this.type = t;
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

    public Element asElement() {
        return (Element) value;
    }

    public String asString() {
        return String.valueOf(value);
    }

    public boolean isDouble() {
        if (value instanceof Double)
            return true;
        if (type != null)
            return type.equalsIgnoreCase("Double");
        return false;
    }

    public boolean isInteger() {
        if (value instanceof Integer)
            return true;
        if (type != null)
            return type.equalsIgnoreCase("Int");
        return false;
    }

    public boolean isString() {
        if (type != null)
            return type.equalsIgnoreCase("String");
        return value.toString().contains("\"");
    }

    public boolean isElemento() {
        return value instanceof Element;
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

    public String toString() {
        return String.valueOf(value);
    }

    enum Tipo {
        TEXTO,
        NUMERO,
        REAL

    }
}