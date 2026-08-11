package com.chzboi42.deverbose.units2;

public class AreaUnit extends AbstractUnit<Area> {

    AreaUnit(double scalar) {
        super(scalar, Area::new);
    }
}
