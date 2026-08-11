package com.chzboi42.deverbose.units2;

public class Distance extends AbstractMeasure<Distance, DistanceUnit>  {

    public static final Distance AU = new Distance(1.496e+11);

    Distance(double metres) {
        super(metres, Distance::new);
    }

    public Area times(Distance other) {
        return new Area(this.baseValue * other.baseValue);
    }

    public Area squared() {
        return times(this);
    }
}
