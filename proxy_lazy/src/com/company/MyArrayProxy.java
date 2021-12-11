package com.company;

public class MyArrayProxy implements Main.Array2D{

    MyArray myArray = null;

    @Override
    public void set(int row, int col, int val) {
        if (myArray == null) load("arrayData");

        myArray.set(row, col, val);
    }

    @Override
    public int get(int row, int col) {
        if (myArray == null) load("arrayData");
        return myArray.get(row, col);
    }

    public void load(String fileName) {
        myArray = new MyArray(fileName);
    }
}
