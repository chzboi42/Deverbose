package com.chzboi42.deverbose.units2;

import java.util.Objects;
import java.util.function.DoubleFunction;

public abstract class Rate<
        A extends AbstractMeasure<A, ?>, 
        B extends AbstractMeasure<B, ?>> 
        extends AbstractMeasure<Rate<A, B>, RateUnit<A, B>> {

    private final DoubleFunction<A> numeratorConstructor;
    private final DoubleFunction<B> denominatorConstructor;

    Rate(
            double baseValue, 
            DoubleFunction<A> numeratorConstructor, 
            DoubleFunction<B> denominatorConstructor) {
        super(baseValue, bVal -> new Rate<>(bVal, numeratorConstructor, denominatorConstructor) {});
        this.numeratorConstructor = numeratorConstructor;
        this.denominatorConstructor = denominatorConstructor;
    }

    /**
     * Given Denominator, find Numerator.
     * Rate * Denominator = Numerator
     * Example: 5 km/h * 2 hours = 10 km
     */
    public A getNumeratorFor(B denominator) {
        double baseNumeratorValue = this.baseValue * Objects.requireNonNull(denominator).baseValue;
        return numeratorConstructor.apply(baseNumeratorValue);
    }

    public A times(B denominator) {
        return getNumeratorFor(denominator);
    }

    /**
     * Given Numerator, find Denominator.
     * Numerator / Rate = Denominator
     * Example: 10 km / (5 km/h) = 2 hours
     */
    public B getDenominatorFor(A numerator) {
        if (this.baseValue == 0) {
            throw new ArithmeticException("Cannot calculate denominator for a rate of zero.");
        }
        double baseDenominatorValue = Objects.requireNonNull(numerator).baseValue / this.baseValue;
        return denominatorConstructor.apply(baseDenominatorValue);
    }
}