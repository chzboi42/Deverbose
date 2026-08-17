package com.chzboi42.deverbose.units2;

import java.util.function.DoubleFunction;

public class RateUnit<A extends AbstractMeasure<A, ?>, B extends AbstractMeasure<B, ?>> 
        extends AbstractRateUnit<A, B, Rate<A, B>> {

    private final DoubleFunction<A> numeratorConstructor;
    private final DoubleFunction<B> denominatorConstructor;

    public RateUnit(
            AbstractUnit<A, ?> numeratorUnit, 
            AbstractUnit<B, ?> denominatorUnit,
            DoubleFunction<A> numeratorConstructor,
            DoubleFunction<B> denominatorConstructor) {
        super(numeratorUnit, denominatorUnit, 
              val -> new Rate<>(val, numeratorConstructor, denominatorConstructor));
        this.numeratorConstructor = numeratorConstructor;
        this.denominatorConstructor = denominatorConstructor;
    }

    @Override
    public Rate<A, B> of(double value) {
        return measureConstructor.apply(convertToBase(value));
    }

    @Override
    public RateUnit<A, B> scale(double value) {
        return new RateUnit<>(
            getNumeratorUnit().scale(value), 
            getDenominatorUnit(), 
            this.numeratorConstructor,
            this.denominatorConstructor
        );
    }
}