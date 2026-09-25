package com.chzboi42.deverbose.units2;

import java.util.function.DoubleFunction;

abstract class AbstractRateUnit<
        A extends AbstractMeasure<A, ?>, 
        B extends AbstractMeasure<B, ?>,
        R extends AbstractRate<A, B, R>> 
        extends AbstractUnit<R, AbstractRateUnit<A, B, R>> {

    private final AbstractUnit<A, ?> numeratorUnit;
    private final AbstractUnit<B, ?> denominatorUnit;

    protected AbstractRateUnit(
            AbstractUnit<A, ?> numeratorUnit, 
            AbstractUnit<B, ?> denominatorUnit, 
            DoubleFunction<R> rateConstructor) {
        
        super(
            val -> numeratorUnit.convertToBase(val) / denominatorUnit.convertToBase(1.0),
            baseVal -> numeratorUnit.convertFromBase(baseVal * denominatorUnit.convertToBase(1.0)),
            rateConstructor,
            s -> null
        );

        this.numeratorUnit = numeratorUnit;
        this.denominatorUnit = denominatorUnit;
    }

    @Override
    public abstract R of(double value);

    @Override
    public abstract AbstractRateUnit<A, B, R> scale(double value);

    public AbstractUnit<A, ?> getNumeratorUnit() { return numeratorUnit; }

    public AbstractUnit<B, ?> getDenominatorUnit() { return denominatorUnit; }
}