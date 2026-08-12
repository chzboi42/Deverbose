package com.chzboi42.deverbose.units2;

public class Force extends AbstractMeasure<Force, ForceUnit> {

    Force(double newtons) {
        super(newtons, Force::new);
    }

    public Pressure per(Area unitArea) {
        return new Pressure(this.baseValue / unitArea.baseValue);
    }
}
