package com.chzboi42.deverbose.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Tuple<E> { // Marked final so nobody can subclass and bypass rules

    private final List<E> list; // Program to the List interface
    
    @SafeVarargs
    public Tuple(E... items) {
        // Defensive copy + wrapping in an unmodifiable list
        this.list = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(items)));
    }

    public Tuple(List<E> items) {
        // Creates a brand new ArrayList copy so the original source can't modify this one
        this.list = Collections.unmodifiableList(new ArrayList<>(items));
    }

    public Tuple(Consumer<ArrayList<E>> a) {
        // 1. Create a temporary list for the constructor to modify
        ArrayList<E> temp = new ArrayList<>();
        // 2. Let the consumer add elements ONLY right now
        a.accept(temp);
        // 3. Lock it down permanently. Even if they saved a reference to 'temp', 
        // modifying 'temp' later won't affect our locked 'this.list'.
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
        // subList(start, end) is exclusive of the end index.
        // We pass the sublist directly to our List constructor which safely copies it.
        return new Tuple<>(list.subList(start, end));
    }
}