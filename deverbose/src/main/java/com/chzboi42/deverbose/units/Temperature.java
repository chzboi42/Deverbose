package com.chzboi42.deverbose.units;

public class Temperature {
    public static final Temperature ABSOLUTE_ZERO = Kelvin.of(0.0);
    private final double kelvin;

    private Temperature(double kelvin) {
        this.kelvin = kelvin;
    }

    // --- Constructors ---

    public static class Kelvin {
        public static Temperature of(double value) {
            return new Temperature(value);
        }
    }

    public static class Celsius {
        public static Temperature of(double value) {
            return new Temperature(value + 273.15);
        }
    }

    public static class Fahrenheit {
        public static Temperature of(double value) {
            return new Temperature((value - 32) * 5/9 + 273.15);
        }
    }

    // --- Conversions ---

    public double inKelvin() {
        return this.kelvin;
    }

    public double inCelsius() {
        return this.kelvin - 273.15;
    }

    public double inFahrenheit() {
        return (this.kelvin - 273.15) * 9/5 + 32;
    }

    // --- Comparisons ---

    public boolean gt(Temperature other) {
        return Double.compare(this.kelvin, other.kelvin) > 0;
    }

    public boolean gte(Temperature other) {
        return Double.compare(this.kelvin, other.kelvin) >= 0;
    }

    public boolean lt(Temperature other) {
        return Double.compare(this.kelvin, other.kelvin) < 0;
    }

    public boolean lte(Temperature other) {
        return Double.compare(this.kelvin, other.kelvin) <= 0;
    }

    public boolean isEqualTo(Temperature other) {
        return Double.compare(this.kelvin, other.kelvin) == 0;
    }

    // --- Arithmetic ---

    public Temperature plus(Temperature other) {
        return new Temperature(this.kelvin + other.kelvin);
    }

    public Temperature minus(Temperature other) {
        return new Temperature(this.kelvin - other.kelvin);
    }
}