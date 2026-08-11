package com.chzboi42.deverbose.units2;

import static com.chzboi42.deverbose.units2.Units.Kilograms;
import static com.chzboi42.deverbose.units2.Units.Metres;
import static com.chzboi42.deverbose.units2.Units.Seconds;

public class Mass extends AbstractMeasure<Mass, MassUnit> {

    Mass(double grams) {
        super(grams, Mass::new);
    }

    public Force times(Rate<Rate<Distance, Time>, Time> accel) {
        return new Force(this.in(Kilograms) * accel.in(Metres.per(Seconds).per(Seconds)));
    }
}
