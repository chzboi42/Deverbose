package com.chzboi42.deverbose.units2;

public class AngularVelocity extends Rate<Angle, Time> {

    AngularVelocity(double radiansPerSecond) {
        super(radiansPerSecond, Angle::new, Time::new);
    }
}
