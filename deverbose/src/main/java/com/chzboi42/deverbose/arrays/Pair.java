package com.chzboi42.deverbose.arrays;

public class Pair<A, B> extends Tuple<Object> {

    public Pair(A a, B b) {
        super(a, b);
    }

    @SuppressWarnings("unchecked")
    public A getFirst() {
        return (A) get(0);
    }

    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }
}
