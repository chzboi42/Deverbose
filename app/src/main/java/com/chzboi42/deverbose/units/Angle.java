package com.chzboi42.deverbose.units;

public class Angle {
    private final double degrees;

    private Angle(double degrees) {
        this.degrees = degrees;
    }

    // --- Constructors ---

    public static class Radians {
        public static Angle of(double value) {
            return new Angle(Math.toDegrees(value));
        }
    }

    public static class Degrees {
        public static Angle of(double value) {
            return new Angle(value);
        }
    }

    public static class Gradians {
        public static Angle of(double value) {
            return new Angle(value / 10.0 * 9.0);
        }
    }

    public static class Rotations {
        public static Angle of(double value) {
            return new Angle(value * 360);
        }
    }

    // --- Conversions ---

    public double inRadians() {
        return Math.toRadians(this.degrees);
    }

    public double inDegrees() {
        return this.degrees;
    }

    public double inGradians() {
        return this.degrees * 10.0 / 9.0;
    }

    public double inRotations() {
        return this.degrees / 360;
    }

    // --- Normalization  ---

    public Angle normalize() {
        return new Angle(((this.degrees % 360) + 360) % 360);
    }

    // --- Comparisons ---

    public boolean gt(Angle other) {
        return Double.compare(this.degrees, other.degrees) > 0;
    }

    public boolean gte(Angle other) {
        return Double.compare(this.degrees, other.degrees) >= 0;
    }

    public boolean lt(Angle other) {
        return Double.compare(this.degrees, other.degrees) < 0;
    }

    public boolean lte(Angle other) {
        return Double.compare(this.degrees, other.degrees) <= 0;
    }

    public boolean isEqualTo(Angle other) {
        return Double.compare(this.degrees, other.degrees) == 0;
    }

    // --- Arithmetic ---

    public Angle plus(Angle other) {
        return new Angle(this.degrees + other.degrees);
    }

    public Angle minus(Angle other) {
        return new Angle(this.degrees - other.degrees);
    }

    public Angle times(double scalar) {
        return new Angle(this.degrees * scalar);
    }

    public Angle dividedBy(double scalar) {
        return new Angle(this.degrees / scalar);
    }

    // --- Trig helpers ---

    public double sin() {
        return Math.sin(Math.toRadians(this.degrees));
    }

    public double cos() {
        return Math.cos(Math.toRadians(this.degrees));
    }

    public double tan() {
        return Math.tan(Math.toRadians(this.degrees));
    }
}