package com.chzboi42.deverbose.units2;

public class AreaUnit extends AbstractUnit<Area, AreaUnit> {

    AreaUnit(double scalar) {
        super(scalar, Area::new, AreaUnit::new);
    }
}
