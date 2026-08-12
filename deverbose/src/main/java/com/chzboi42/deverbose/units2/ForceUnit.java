package com.chzboi42.deverbose.units2;

public class ForceUnit extends AbstractUnit<Force, ForceUnit> {

    ForceUnit(double scalar) {
        super(scalar, Force::new, ForceUnit::new);
    }
}
