package com.chzboi42.deverbose.units2;

public class Pressure extends AbstractMeasure<Pressure, PressureUnit> {

    Pressure(double pascals) {
        super(pascals, Pressure::new);
    }
}
