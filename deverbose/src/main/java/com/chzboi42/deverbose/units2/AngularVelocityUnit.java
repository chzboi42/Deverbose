package com.chzboi42.deverbose.units2;

public class AngularVelocityUnit extends RateUnit<Angle, Time>{

    AngularVelocityUnit(AngleUnit angle, TimeUnit time) {
        super(angle, time, Angle::new, Time::new);
    }

    @Override
    public AngularVelocity of(double value) {
        return new AngularVelocity(convertToBase(value));
    }
}
