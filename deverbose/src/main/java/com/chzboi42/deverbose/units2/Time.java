package com.chzboi42.deverbose.units2;

public class Time extends AbstractMeasure<Time, TimeUnit>{

    Time(double seconds) {
        super(seconds, Time::new);
    }
}
