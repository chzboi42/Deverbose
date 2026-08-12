package com.chzboi42.deverbose.units2;

public class AngleUnit extends AbstractUnit<Angle, AngleUnit>{

    /**
     * 1 of this AngleUnit = <scalar> Radians
     * @param scalar
     */
    AngleUnit(double scalar) {
        super(scalar, Angle::new, AngleUnit::new);
    }

    public AngularVelocityUnit per(TimeUnit time) {
        return new AngularVelocityUnit(this, time);
    }
}
