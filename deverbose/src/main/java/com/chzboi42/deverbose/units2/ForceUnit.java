package com.chzboi42.deverbose.units2;

public class ForceUnit extends AbstractUnit<Force> {

    ForceUnit(double scalar) {
        super(scalar, Force::new);
    }
}
