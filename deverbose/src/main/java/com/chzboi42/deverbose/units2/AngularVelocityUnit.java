package com.chzboi42.deverbose.units2;

public class AngularVelocityUnit extends AbstractRateUnit<Angle, Time, AngularVelocity>{

    AngularVelocityUnit(AngleUnit angle, TimeUnit time) {
        super(angle, time, AngularVelocity::new);
    }

    @Override
    public AngularVelocity of(double value) {
        return new AngularVelocity(convertToBase(value));
    }

    @Override
    public AngularVelocityUnit scale(double scalar) {
        return new AngularVelocityUnit((AngleUnit) getNumeratorUnit().scale(scalar * getDenominatorUnit().convertToBase(1.0)), (TimeUnit) getDenominatorUnit());
    }
}
    