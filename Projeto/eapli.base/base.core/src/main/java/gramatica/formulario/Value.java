package gramatica.formulario;

import org.w3c.dom.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public LocalDate asDate () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // create a LocalDate object and
        LocalDate dt = LocalDate.parse(this.value.toString(), formatter);
        return dt ;
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
        return value.toString().contains("\"");
    }

    public boolean isElemento() {
        return value instanceof Element;
    }

    public boolean isDate () {
        return isValidDate(value.toString());
    }
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
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
}