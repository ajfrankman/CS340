import java.lang.reflect.Array;
import java.util.ArrayList;



public class Algorithm {


    public static <T extends Comparable> Stats calcStats(T[] elems)
        throws Exception {
        T min;
        T max;

        min = elems[0];
        max = elems[0];
        for (int i = 0; i < elems.length; i++) {
            if (min.compareTo(elems[i]) > 0) min = elems[i];
            if (max.compareTo(elems[i]) < 0) max = elems[i];

        }
        Stats stats = new Stats(min, max);

        return stats;
    }

    public static void main(String[] args) throws Exception {
        Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,99,0};
        Stats tempStat = calcStats(numbers);
        System.out.println("Max num: " + tempStat.max);
        System.out.println("Min num: " + tempStat.min);

        System.out.println("\n");

        String[] strings = new String[]{"you", "say", "hello", "I", "say", "goodbye"};
        Stats stringStat = calcStats(strings);
        System.out.println("Max string: " + stringStat.max);
        System.out.println("Min string: " + stringStat.min);
    }
}
