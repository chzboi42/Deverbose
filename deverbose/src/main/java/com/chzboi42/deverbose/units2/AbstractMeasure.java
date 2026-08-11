package com.chzboi42.deverbose.units2;

import java.util.Objects;
import java.util.function.DoubleFunction;

public abstract class AbstractMeasure<Q extends AbstractMeasure<Q, U>, U extends AbstractUnit<Q>> {

    final double baseValue;
    private final DoubleFunction<Q> constructor;

    AbstractMeasure(double baseValue, DoubleFunction<Q> constructor) {
        this.baseValue = baseValue;
        this.constructor = constructor;
    }

    public final double in(U unit) {
        return Objects.requireNonNull(unit).convertFromBase(this.baseValue);
    }

    public final Q negate() {
        return constructor.apply(-this.baseValue);
    }

    public final Q abs() {
        return constructor.apply(Math.abs(this.baseValue));
    }

    public final boolean gt(Q comparison) {
        return Double.compare(this.baseValue, Objects.requireNonNull(comparison).baseValue) > 0;
    }

    public final boolean gte(Q comparison) {
        return Double.compare(this.baseValue, Objects.requireNonNull(comparison).baseValue) >= 0;
    }

    public final boolean lt(Q comparison) {
        return Double.compare(this.baseValue, Objects.requireNonNull(comparison).baseValue) < 0;
    }

    public final boolean lte(Q comparison) {
        return Double.compare(this.baseValue, Objects.requireNonNull(comparison).baseValue) <= 0;
    }

    public final boolean isEqualTo(Q comparison) {
        return Double.compare(this.baseValue, Objects.requireNonNull(comparison).baseValue) == 0;
    }

    public final Q plus(Q other) {
        return constructor.apply(this.baseValue + Objects.requireNonNull(other).baseValue);
    }

    public final Q minus(Q other) {
        return constructor.apply(this.baseValue - Objects.requireNonNull(other).baseValue);
    }

    public final Q times(double scalar) {
        return constructor.apply(this.baseValue * scalar);
    }

    public final Q dividedBy(double scalar) {
        return constructor.apply(this.baseValue / scalar);
    }

    public final double dividedBy(Q other) {
        return this.baseValue / Objects.requireNonNull(other).baseValue;
    }
}
