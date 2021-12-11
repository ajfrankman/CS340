package com.company;

public class Entry<T extends Comparable, V> {

    T key;
    V value;

    public Entry(T key, V value) {
        this.key = key;
        this.value = value;
    }


    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
