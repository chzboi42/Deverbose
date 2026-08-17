package com.chzboi42.deverbose.units2;

import static com.chzboi42.deverbose.units2.Units.Kilograms;

public class Mass extends AbstractMeasure<Mass, MassUnit> {

    Mass(double grams) {
        super(grams, Mass::new);
    }

    public Force times(AbstractRate<? extends AbstractRate<Distance, Time, ?>, Time, ?> accel) {
        return new Force(this.in(Kilograms) * accel.baseValue);
    }
}
