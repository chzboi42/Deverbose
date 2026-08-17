package com.chzboi42.deverbose.units2;

import java.util.function.DoubleFunction;

public class Rate<A extends AbstractMeasure<A, ?>, B extends AbstractMeasure<B, ?>> 
        extends AbstractRate<A, B, Rate<A, B>> {

    public Rate(
            double baseValue, 
            DoubleFunction<A> numeratorConstructor, 
            DoubleFunction<B> denominatorConstructor) {
        super(baseValue, numeratorConstructor, denominatorConstructor, 
              val -> new Rate<>(val, numeratorConstructor, denominatorConstructor));
    }
}