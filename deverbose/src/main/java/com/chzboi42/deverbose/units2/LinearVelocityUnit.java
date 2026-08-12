package com.chzboi42.deverbose.units2;

public class LinearVelocityUnit extends RateUnit<Distance, Time> {

    LinearVelocityUnit(DistanceUnit distance, TimeUnit time) {
        super(distance, time, Distance::new, Time::new);
    } 

    @Override
    public LinearVelocity of(double value) {
        return new LinearVelocity(convertToBase(value));
    }

    @Override
    protected LinearVelocityUnit withScalar(double scalar) {
        // Create an updated DistanceUnit with the scaled ratio
        return new LinearVelocityUnit((DistanceUnit) getNumeratorUnit().withScalar(scalar * getDenominatorUnit().convertToBase(1.0)), (TimeUnit) getDenominatorUnit());
    }
}
