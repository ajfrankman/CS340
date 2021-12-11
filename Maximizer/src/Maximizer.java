public class Maximizer<T extends Comparable> {
        T obj;
        Maximizer(T obj) {
            this.obj = obj;
        }

        public void updateValue(T temp) {
            if (this.obj.compareTo(temp)<0) this.obj = temp;
        }

        public T getValue() {
            return this.obj;
        }

    public static void main(String[] args) {
        Maximizer<Integer> maximizerInteger = new Maximizer<Integer>(6);
        maximizerInteger.updateValue(7);
        System.out.println("Initialized with 6 and added 7");
        System.out.println("Max Integer: " + maximizerInteger.getValue());

        System.out.println("\n");

        Maximizer<String> maximizerString = new Maximizer<String>("bye");
        maximizerString.updateValue("hello");
        System.out.println("Initialized with \"bye\" and added \"hello\"");
        System.out.println("Max string: " + maximizerString.getValue());
    }
}
