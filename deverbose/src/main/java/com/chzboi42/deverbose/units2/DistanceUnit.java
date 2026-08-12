package com.chzboi42.deverbose.units2;

public class DistanceUnit extends AbstractUnit<Distance> {

    /**
     * 1 of this DistanceUnit = <scalar> Metres
     * @param scalar
     */
    DistanceUnit(double scalar) {
        super(scalar, Distance::new);
    }

    @Override
    protected DistanceUnit withScalar(double scalar) {
        return new DistanceUnit(scalar);
    }

    public LinearVelocityUnit per(TimeUnit time) {
        return new LinearVelocityUnit(this, time);
    }
}
