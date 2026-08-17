package com.chzboi42.deverbose.units2;

public class AngularVelocity extends AbstractRate<Angle, Time, AngularVelocity> {

    AngularVelocity(double radiansPerSecond) {
        super(radiansPerSecond, Angle::new, Time::new, AngularVelocity::new);
    }
}
