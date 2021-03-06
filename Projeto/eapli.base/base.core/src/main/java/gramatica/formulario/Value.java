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
        return LocalDate.parse(this.value.toString(), formatter);
    }

    public static String localDate (LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }


    public String asString() {
        return String.valueOf(value);
    }

    public boolean isDouble() {
        if (value.toString() == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(value.toString());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isInteger() {
        if (value.toString() == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(value.toString());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isString() {
        return removeAspas(value) instanceof java.lang.String;
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

    public static boolean isValidNumber(String numberToTest){
        return numberToTest.matches("^[0-9]+([.][0-9]+)?$");
    }

    public String removeAspas(Object val) {
        if (val.toString().contains("\"")) {
            return val.toString().substring(1, val.toString().length() - 1);
        }
        return val.toString();
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