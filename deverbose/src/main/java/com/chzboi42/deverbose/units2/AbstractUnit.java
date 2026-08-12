package com.chzboi42.deverbose.units2;

import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

public abstract class AbstractUnit<Q extends AbstractMeasure<Q, ?>> {

    private final DoubleUnaryOperator toBase;
    private final DoubleUnaryOperator fromBase;
    final DoubleFunction<Q> constructor;

    AbstractUnit(DoubleUnaryOperator toBase, DoubleUnaryOperator fromBase, DoubleFunction<Q> constructor) {
        this.toBase = toBase;
        this.fromBase = fromBase;
        this.constructor = constructor;
    }

    AbstractUnit(double scalar, DoubleFunction<Q> constructor) {
        this(v -> v * scalar, base -> base / scalar, constructor);
    }

    public Q of(double value) {
        return constructor.apply(convertToBase(value));
    }

    public final <B extends AbstractMeasure<B, ?>> RateUnit<Q, B> per(AbstractUnit<B> denominatorUnit) {
        return new RateUnit<>(this, denominatorUnit, this.constructor, denominatorUnit.constructor) {};
    }

    final double convertToBase(double value) {
        return toBase.applyAsDouble(value);
    }

    final double convertFromBase(double baseValue) {
        return fromBase.applyAsDouble(baseValue);
    }

    public final Q zero() {
        return of(0);
    }

    public final Q half() {
        return of(0.5);
    }

    public final Q one() {
        return of(1);
    }

    public final Q two() {
        return of(2);
    }

    public final Q infinite() {
        return of(Double.POSITIVE_INFINITY);
    }
}
