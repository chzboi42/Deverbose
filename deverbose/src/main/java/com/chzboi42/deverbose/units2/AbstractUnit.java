package com.chzboi42.deverbose.units2;

import java.util.Objects;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

public abstract class AbstractUnit<Q extends AbstractMeasure<Q, U>, U extends AbstractUnit<Q,U>> {

    private final DoubleUnaryOperator toBase;
    private final DoubleUnaryOperator fromBase;
    final DoubleFunction<Q> measureConstructor;
    final DoubleFunction<U> unitConstructor;

    AbstractUnit(DoubleUnaryOperator toBase, DoubleUnaryOperator fromBase, DoubleFunction<Q> measureConstructor, DoubleFunction<U> unitConstructor) {
        this.toBase = toBase;
        this.fromBase = fromBase;
        this.measureConstructor = measureConstructor;
        this.unitConstructor = unitConstructor;
    }

    AbstractUnit(double scalar, DoubleFunction<Q> measureConstructor, DoubleFunction<U> unitConstructor) {
        this(v -> v * scalar, base -> base / scalar, measureConstructor, unitConstructor);
    }   

    public Q of(double value) {
        return measureConstructor.apply(convertToBase(value));
    }

    /**
     * 1 of this new unit = <i>(value)</i> of the original unit.
     * @param value how many of the original units are equal to 1 of this new unit
     * @return the new unit complete with scalar
     */
    public U scale(double value) {
        return unitConstructor.apply(convertToBase(1.0) * value);
    }

    public final <B extends AbstractMeasure<B, UB>, UB extends AbstractUnit<B, UB>> RateUnit<Q, B> per(AbstractUnit<B, UB> denominatorUnit) {
        return new RateUnit<Q, B>(
            this, 
            denominatorUnit, 
            this.measureConstructor, 
            denominatorUnit.measureConstructor
        ) {
            @Override
            public Rate<Q, B> of(double value) {
                return new Rate<Q, B>(
                    convertToBase(value), 
                    AbstractUnit.this.measureConstructor, 
                    denominatorUnit.measureConstructor
                ) {};
            }

            @Override
            public RateUnit<Q, B> scale(double factor) {
                return Objects.requireNonNull(AbstractUnit.this.scale(factor)).per(denominatorUnit);
            }
        };
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
