package com.company;

public class randomClass implements Main.randomInterface{
    @Override
    public void printHello() {
        System.out.println("Hello");
    }

    @Override
    public void printBye() {
        System.out.println("Bye");
    }
}
