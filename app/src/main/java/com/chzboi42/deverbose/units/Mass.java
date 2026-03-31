package com.chzboi42.deverbose.units;

public class Mass {
    private final double grams;

    private Mass(double grams) {
        this.grams = grams;
    }

    // --- Metric units ---

    public static class Milligrams {
        public static Mass of(double value) {
            return new Mass(value / 1000);
        }
    }

    public static class Centigrams {
        public static Mass of(double value) {
            return new Mass(value / 100);
        }
    }

    public static class Decigrams {
        public static Mass of(double value) {
            return new Mass(value / 10);
        }
    }

    public static class Grams {
        public static Mass of(double value) {
            return new Mass(value);
        }
    }

    public static class Kilograms {
        public static Mass of(double value) {
            return new Mass(value * 1000);
        }
    }

    public static class Tonnes {
        public static Mass of(double value) {
            return new Mass(value * 1_000_000);
        }
    }

    // --- Imperial units ---

    public static class Ounces {
        public static Mass of(double value) {
            return new Mass(value * 28.349523125);
        }
    }

    public static class Pounds {
        public static Mass of(double value) {
            return new Mass(value * 453.59237);
        }
    }

    public static class Stones {
        public static Mass of(double value) {
            return new Mass(value * 6350.29318);
        }
    }

    public static class ShortTons { // US ton
        public static Mass of(double value) {
            return new Mass(value * 907_184.74);
        }
    }

    public static class LongTons { // UK ton
        public static Mass of(double value) {
            return new Mass(value * 1_016_046.9088);
        }
    }

    // --- Conversions (metric) ---

    public double inMilligrams() {
        return this.grams * 1000;
    }

    public double inCentigrams() {
        return this.grams * 100;
    }

    public double inDecigrams() {
        return this.grams * 10;
    }

    public double inGrams() {
        return this.grams;
    }

    public double inKilograms() {
        return this.grams / 1000;
    }

    public double inTonnes() {
        return this.grams / 1_000_000;
    }

    // --- Conversions (imperial) ---

    public double inOunces() {
        return this.grams / 28.349523125;
    }

    public double inPounds() {
        return this.grams / 453.59237;
    }

    public double inStones() {
        return this.grams / 6350.29318;
    }

    public double inShortTons() {
        return this.grams / 907_184.74;
    }

    public double inLongTons() {
        return this.grams / 1_016_046.9088;
    }

    // --- Comparisons ---

    public boolean gt(Mass comparison) {
        return Double.compare(this.grams, comparison.grams) > 0;
    }

    public boolean gte(Mass comparison) {
        return Double.compare(this.grams, comparison.grams) >= 0;
    }

    public boolean lt(Mass comparison) {
        return Double.compare(this.grams, comparison.grams) < 0;
    }

    public boolean lte(Mass comparison) {
        return Double.compare(this.grams, comparison.grams) <= 0;
    }

    public boolean isEqualTo(Mass comparison) {
        return Double.compare(this.grams, comparison.grams) == 0;
    }

    // --- Arithmetic ---

    public Mass plus(Mass other) {
        return new Mass(this.grams + other.grams);
    }

    public Mass minus(Mass other) {
        return new Mass(this.grams - other.grams);
    }

    public Mass times(double scalar) {
        return new Mass(this.grams * scalar);
    }

    public Mass dividedBy(double scalar) {
        return new Mass(this.grams / scalar);
    }
}