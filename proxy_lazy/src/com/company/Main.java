package com.company;

public class Main {



    public interface Array2D {
        void set(int row, int col, int val);
        int get(int row, int col);
    }

    public static void main(String[] args) {

        MyArrayProxy myArrayProxy = new MyArrayProxy();

        System.out.println(myArrayProxy.get(0,0));
        myArrayProxy.set(0,0, 100);
        System.out.println(myArrayProxy.get(0,0));

    }
}
