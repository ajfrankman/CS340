package com.company;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public interface randomInterface {
        abstract void printHello();
        abstract void printBye();
    }

    public static void main(String[] args) throws Exception {
        RandomProxy randomProxy = new RandomProxy(Calendar.getInstance());
        randomProxy.hello();
        randomProxy.bye();

        //If you change the parameters in RandomProxy, you will find that it works wonderfully!
    }
}
