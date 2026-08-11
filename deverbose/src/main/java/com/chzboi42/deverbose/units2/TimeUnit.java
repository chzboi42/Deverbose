package com.chzboi42.deverbose.units2;

public class TimeUnit extends AbstractUnit<Time>{

    TimeUnit(double scalar) {
        super(scalar, Time::new);
    }

    
}
