package com.chzboi42.deverbose.units2;

public class AreaUnit extends AbstractUnit<Area> {

    AreaUnit(double scalar) {
        super(scalar, Area::new);
    }

    @Override
    protected AreaUnit withScalar(double scalar) {
        return new AreaUnit(scalar);
    }
}
