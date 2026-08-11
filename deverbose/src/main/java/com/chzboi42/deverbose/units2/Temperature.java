package com.chzboi42.deverbose.units2;

public class Temperature extends AbstractMeasure<Temperature, TemperatureUnit> {

    Temperature(double kelvin) {
        super(kelvin, Temperature::new);
    }
}
