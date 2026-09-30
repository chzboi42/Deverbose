package com.chzboi42.deverbose.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Tuple<E> {

    private final List<E> list;
    
    @SafeVarargs
    public Tuple(E... items) {
        this.list = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(items)));
    }

    public Tuple(List<E> items) {
        this.list = Collections.unmodifiableList(new ArrayList<>(items));
    }

    public Tuple(Consumer<ArrayList<E>> a) {
        ArrayList<E> temp = new ArrayList<>();
        a.accept(temp);
        this.list = Collections.unmodifiableList(temp);
    }

    public E get(int index) {
        return list.get(index);
    }

    public int indexOf(E item) {
        return list.indexOf(item);
    }

    public boolean contains(E item) {
        return list.contains(item);
    }

    public int size() {
        return list.size();
    }

    public List<E> set() {
        return list;
    }

    public Tuple<E> split(int start, int end) {
        return new Tuple<>(list.subList(start, end));
    }
}