package com.company;
import java.util.*;


public class RandomProxy extends randomClass {

    Calendar c;
    int dayOfWeek;
    int hourOfDay;

    public RandomProxy(Calendar calendar) {
        this.c = calendar;
        this.dayOfWeek = this.c.get(Calendar.DAY_OF_WEEK);
        this.hourOfDay = this.c.get(Calendar.HOUR_OF_DAY);
    }

    public void hello() throws Exception {
        try {
            if ((dayOfWeek == 0 || dayOfWeek == 6) || (hourOfDay <= 7 || hourOfDay >= 22)) {
                throw new Exception("Can't run on Saturday and Sunday");
            } else {
                this.printHello();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void bye() throws Exception {
        try {
            if ((dayOfWeek == 0 || dayOfWeek == 6) || (hourOfDay <= 7 || hourOfDay >= 22)) {
                throw new Exception("Can't run on Saturday and Sunday");
            } else {
                this.printBye();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
