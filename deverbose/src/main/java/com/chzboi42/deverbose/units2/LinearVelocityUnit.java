package com.chzboi42.deverbose.units2;

public class LinearVelocityUnit extends AbstractRateUnit<Distance, Time, LinearVelocity> {

    LinearVelocityUnit(DistanceUnit distance, TimeUnit time) {
        super(distance, time, LinearVelocity::new);
    } 

    @Override
    public LinearVelocity of(double value) {
        return new LinearVelocity(convertToBase(value));
    }

    @Override
    public LinearVelocityUnit scale(double scalar) {
        return new LinearVelocityUnit((DistanceUnit) getNumeratorUnit().scale(scalar), (TimeUnit) getDenominatorUnit());
    }
}
