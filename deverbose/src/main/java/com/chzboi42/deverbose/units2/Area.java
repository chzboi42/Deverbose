package com.chzboi42.deverbose.units2;

public class Area extends AbstractMeasure<Area, AreaUnit> {

    Area(double squareMetres) {
        super(squareMetres, Area::new);
    }

    public Distance dividedBy(Distance other) {
        return new Distance(this.baseValue / other.baseValue);
    }

    public Volume times(Distance other) {
        return new Volume(this.baseValue * other.baseValue);
    }
}
