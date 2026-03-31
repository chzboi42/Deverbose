package com.chzboi42.deverbose.units;

public class Distance {
    public static final Distance AU = Kilometres.of(1.496e+8);
    private final double metres;

    private Distance(double metres) {
        this.metres = metres;
    }

    public static class Millimetres {
        public static Distance of(double value) {
            return new Distance(value / 1000);
        }
    }

    public static class Centimetres {
        public static Distance of(double value) {
            return new Distance(value / 100);
        }
    }

    public static class Decimetres {
        public static Distance of(double value) {
            return new Distance(value / 10);
        }
    }

    public static class Metres {
        public static Distance of(double value) {
            return new Distance(value);
        }
    }

    public static class Decametres {
        public static Distance of(double value) {
            return new Distance(value * 10);
        }
    }

    public static class Hectometres {
        public static Distance of(double value) {
            return new Distance(value * 100);
        }
    }

    public static class Kilometres {
        public static Distance of(double value) {
            return new Distance(value * 1000);
        }
    }

    public static class Inches {
        public static Distance of(double value) {
            return new Distance(value * 0.0254);
        }
    }

    public static class Feet {
        public static Distance of(double value) {
            return new Distance(value * 0.3048);
        }
    }

    public static class Yards {
        public static Distance of(double value) {
            return new Distance(value * 0.9144);
        }
    }

    public static class Miles {
        public static Distance of(double value) {
            return new Distance(value * 1609.344);
        }
    }

    public static class NauticalMiles {
        public static Distance of(double value) {
            return new Distance(value * 1852);
        }
    }

    public static class LightYears {
        public static Distance of(double value) {
            return new Distance(value * 9.461e+15);
        }
    }

    public double inMillimetres() {
        return this.metres * 1000;
    }

    public double inCentimetres() {
        return this.metres * 100;
    }

    public double inDecimetres() {
        return this.metres * 10;
    }

    public double inMetres() {
        return this.metres;
    }

    public double inDecametres() {
        return this.metres / 10;
    }

    public double inHectometres() {
        return this.metres / 100;
    }

    public double inKilometres() {
        return this.metres / 1000;
    }
    
    public double inInches() {
        return this.metres / 0.0254;
    }

    public double inFeet() {
        return this.metres / 0.3048;
    }

    public double inYards() {
        return this.metres / 0.9144;
    }

    public double inMiles() {
        return this.metres / 1609.344;
    }

    public double inNauticalMiles() {
        return this.metres / 1852;
    }

    public double inLightYears() {
        return this.metres / 9.461e+15;
    }


    public boolean gt(Distance comparison) {
        return Double.compare(this.metres, comparison.metres) > 0;
    }

    public boolean gte(Distance comparison) {
        return Double.compare(this.metres, comparison.metres) >= 0;
    }

    public boolean lt(Distance comparison) {
        return Double.compare(this.metres, comparison.metres) < 0;
    }

    public boolean lte(Distance comparison) {
        return Double.compare(this.metres, comparison.metres) <= 0;
    }

    public boolean isEqualTo(Distance comparison) {
        return Double.compare(this.metres, comparison.metres) == 0;
    }

    public Distance plus(Distance other) {
        return new Distance(this.metres + other.metres);
    }

    public Distance minus(Distance other) {
        return new Distance(this.metres - other.metres);
    }

    public Distance times(double scalar) {
        return new Distance(this.metres * scalar);
    }

    public Distance dividedBy(double scalar) {
        return new Distance(this.metres / scalar);
    }


}

