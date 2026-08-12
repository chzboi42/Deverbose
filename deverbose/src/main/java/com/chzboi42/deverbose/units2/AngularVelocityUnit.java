package com.chzboi42.deverbose.units2;

public class AngularVelocityUnit extends RateUnit<Angle, Time>{

    AngularVelocityUnit(AngleUnit angle, TimeUnit time) {
        super(angle, time, Angle::new, Time::new);
    }

    @Override
    public AngularVelocity of(double value) {
        return new AngularVelocity(convertToBase(value));
    }

    @Override
    protected AngularVelocityUnit withScalar(double scalar) {
        // Create an updated DistanceUnit with the scaled ratio
        return new AngularVelocityUnit((AngleUnit) getNumeratorUnit().withScalar(scalar * getDenominatorUnit().convertToBase(1.0)), (TimeUnit) getDenominatorUnit());
    }
}
    