package com.chzboi42.deverbose.units2;

import java.util.function.DoubleFunction;

public abstract class RateUnit<
        A extends AbstractMeasure<A, ?>, 
        B extends AbstractMeasure<B, ?>> 
        extends AbstractUnit<Rate<A, B>> {

    private final AbstractUnit<A> numeratorUnit;
    private final AbstractUnit<B> denominatorUnit;

    RateUnit(
            AbstractUnit<A> numeratorUnit, 
            AbstractUnit<B> denominatorUnit, 
            DoubleFunction<A> numeratorConstructor,
            DoubleFunction<B> denominatorConstructor) {
        
        super(
            val -> numeratorUnit.convertToBase(val) / denominatorUnit.convertToBase(1.0),
            baseVal -> numeratorUnit.convertFromBase(baseVal * denominatorUnit.convertToBase(1.0)),
            baseVal -> new Rate<>(baseVal, numeratorConstructor, denominatorConstructor) {}
        );
        this.numeratorUnit = numeratorUnit;
        this.denominatorUnit = denominatorUnit;
    }

    @Override
    public abstract Rate<A, B> of(double value);

    @Override
    abstract RateUnit<A, B> withScalar(double scalar);

    public AbstractUnit<A> getNumeratorUnit() { return numeratorUnit; }

    public AbstractUnit<B> getDenominatorUnit() { return denominatorUnit; }
}