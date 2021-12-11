package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyArray implements Main.Array2D {
    int row;
    int col;
    int [][] localArray;


    public MyArray(int row, int col) {
        this.row = row;
        this.col = col;
        this.localArray = new int[row][col];
    }

    public MyArray(String fileName) {
        load(fileName);
    }

    public void save(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.localArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream iis = new ObjectInputStream(fis);
            this.localArray = (int[][]) iis.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void set(int row, int col, int val) {
        this.localArray[row][col] = val;
    }

    @Override
    public int get(int row, int col) {
        return this.localArray[row][col];
    }
}
