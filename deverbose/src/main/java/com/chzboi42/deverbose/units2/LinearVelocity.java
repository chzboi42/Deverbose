package com.chzboi42.deverbose.units2;

public class LinearVelocity extends Rate<Distance, Time> {

    LinearVelocity(double metresPerSecond) {
        super(metresPerSecond, Distance::new, Time::new);
    }
}
