package com.chzboi42.deverbose.units2;

public class DistanceUnit extends AbstractUnit<Distance, DistanceUnit> {

    /**
     * 1 of this DistanceUnit = <scalar> Metres
     * @param scalar
     */
    DistanceUnit(double scalar) {
        super(scalar, Distance::new, DistanceUnit::new);
    }

    public LinearVelocityUnit per(TimeUnit time) {
        return new LinearVelocityUnit(this, time);
    }
}
