package com.chzboi42.deverbose.units2;

import java.util.function.DoubleUnaryOperator;

public class TemperatureUnit extends AbstractUnit<Temperature> {

    TemperatureUnit(double scalar) {
        super(scalar, Temperature::new);
    }

    @Override
    protected TemperatureUnit withScalar(double scalar) {
        return new TemperatureUnit(scalar);
    }

    TemperatureUnit(DoubleUnaryOperator toBase, DoubleUnaryOperator fromBase) {
        super(toBase, fromBase, Temperature::new);
    }
}
