package com.chzboi42.deverbose.units2;

public class LinearVelocity extends AbstractRate<Distance, Time, LinearVelocity> {

    LinearVelocity(double metresPerSecond) {
        super(metresPerSecond, Distance::new, Time::new, LinearVelocity::new);
    }
}
