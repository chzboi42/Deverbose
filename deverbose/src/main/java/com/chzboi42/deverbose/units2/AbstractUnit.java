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
        return new RateUnit<>(this, denominatorUnit, this.constructor, denominatorUnit.constructor) {
            @Override
            public Rate<Q, B> of(double value) {
                return new Rate<Q, B>(
                    convertToBase(value), 
                    AbstractUnit.this.constructor, 
                    denominatorUnit.constructor
                ) {};
            }

            @Override
            protected RateUnit<Q, B> withScalar(double scalar) {
                // Re-scale the numerator according to the new scalar base
                double newNumeratorScalar = scalar * denominatorUnit.convertToBase(1.0);
                AbstractUnit<Q> newNumerator = (AbstractUnit<Q>) AbstractUnit.this.withScalar(newNumeratorScalar);
                return newNumerator.per(denominatorUnit);
            }
        };
    }

    abstract AbstractUnit<Q> withScalar(double scalar);

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
