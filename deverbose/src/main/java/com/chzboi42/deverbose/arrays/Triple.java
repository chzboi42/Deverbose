package com.chzboi42.deverbose.arrays;

public class Triple<A, B, C> extends Tuple<Object> {

    public Triple(A a, B b, C c) {
        super(a, b, c);
    }

    @SuppressWarnings("unchecked")
    public A getFirst() {
        return (A) get(0);
    }

    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }
}
