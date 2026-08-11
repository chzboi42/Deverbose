package com.chzboi42.deverbose.units2;

public class PressureUnit extends AbstractUnit<Pressure> {

    PressureUnit(double scalar) {
        super(scalar, Pressure::new);
    }
}
