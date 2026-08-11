package com.chzboi42.deverbose.units2;

public class Angle extends AbstractMeasure<Angle, AngleUnit>{

    private final double radians;

    Angle(double radians) {
        this.radians = radians;
        super(radians, Angle::new);
    }

    public Angle normalize() {
        return new Angle(((this.radians % Math.TAU) + Math.TAU) % Math.TAU);
    }

    public double sin() {
        return Math.sin(this.radians);
    }

    public double cos() {
        return Math.cos(this.radians);
    }

    public double tan() {
        return Math.tan(this.radians);
    }

    public double sinh() {
        return Math.sinh(this.radians);
    }

    public double cosh() {
        return Math.cosh(this.radians);
    }

    public double tanh() {
        return Math.tanh(this.radians);
    }
}
