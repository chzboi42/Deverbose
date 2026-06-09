package com.chzboi42.deverbose.units;

public class Volume {
    private final double litres;

    private Volume(double litres) {
        this.litres = litres;
    }

    // --- Metric units ---

    public static class Millilitres {
        public static Volume of(double value) {
            return new Volume(value / 1000);
        }
    }

    public static class Centilitres {
        public static Volume of(double value) {
            return new Volume(value / 100);
        }
    }

    public static class Decilitres {
        public static Volume of(double value) {
            return new Volume(value / 10);
        }
    }

    public static class Litres {
        public static Volume of(double value) {
            return new Volume(value);
        }
    }

    public static class CubicMetres {
        public static Volume of(double value) {
            return new Volume(value * 1000);
        }
    }

    // --- US units ---

    public static class USFluidOunces {
        public static Volume of(double value) {
            return new Volume(value * 0.0295735295625);
        }
    }

    public static class USCups {
        public static Volume of(double value) {
            return new Volume(value * 0.2365882365);
        }
    }

    public static class USPints {
        public static Volume of(double value) {
            return new Volume(value * 0.473176473);
        }
    }

    public static class USQuarts {
        public static Volume of(double value) {
            return new Volume(value * 0.946352946);
        }
    }

    public static class USGallons {
        public static Volume of(double value) {
            return new Volume(value * 3.785411784);
        }
    }

    // --- UK units ---

    public static class UKFluidOunces {
        public static Volume of(double value) {
            return new Volume(value * 0.0284130625);
        }
    }

    public static class UKPints {
        public static Volume of(double value) {
            return new Volume(value * 0.56826125);
        }
    }

    public static class UKQuarts {
        public static Volume of(double value) {
            return new Volume(value * 1.1365225);
        }
    }

    public static class UKGallons {
        public static Volume of(double value) {
            return new Volume(value * 4.54609);
        }
    }

    // --- Conversions (metric) ---

    public double inMillilitres() {
        return this.litres * 1000;
    }

    public double inCentilitres() {
        return this.litres * 100;
    }

    public double inDecilitres() {
        return this.litres * 10;
    }

    public double inLitres() {
        return this.litres;
    }

    public double inCubicMetres() {
        return this.litres / 1000;
    }

    // --- Conversions (US) ---

    public double inUSFluidOunces() {
        return this.litres / 0.0295735295625;
    }

    public double inUSCups() {
        return this.litres / 0.2365882365;
    }

    public double inUSPints() {
        return this.litres / 0.473176473;
    }

    public double inUSQuarts() {
        return this.litres / 0.946352946;
    }

    public double inUSGallons() {
        return this.litres / 3.785411784;
    }

    // --- Conversions (UK) ---

    public double inUKFluidOunces() {
        return this.litres / 0.0284130625;
    }

    public double inUKPints() {
        return this.litres / 0.56826125;
    }

    public double inUKQuarts() {
        return this.litres / 1.1365225;
    }

    public double inUKGallons() {
        return this.litres / 4.54609;
    }

    // --- Comparisons ---

    public boolean gt(Volume other) {
        return Double.compare(this.litres, other.litres) > 0;
    }

    public boolean gte(Volume other) {
        return Double.compare(this.litres, other.litres) >= 0;
    }

    public boolean lt(Volume other) {
        return Double.compare(this.litres, other.litres) < 0;
    }

    public boolean lte(Volume other) {
        return Double.compare(this.litres, other.litres) <= 0;
    }

    public boolean isEqualTo(Volume other) {
        return Double.compare(this.litres, other.litres) == 0;
    }

    // --- Arithmetic ---

    public Volume plus(Volume other) {
        return new Volume(this.litres + other.litres);
    }

    public Volume minus(Volume other) {
        return new Volume(this.litres - other.litres);
    }

    public Volume times(double scalar) {
        return new Volume(this.litres * scalar);
    }

    public Volume dividedBy(double scalar) {
        return new Volume(this.litres / scalar);
    }
}