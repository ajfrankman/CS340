public class Main {

    public static void main(String[] args) {

        HalloweenFactory hf = new HalloweenFactory();
        DecorationPlacer decorationPlacer1 = new DecorationPlacer(hf);

        GroundhogdayFactory gf = new GroundhogdayFactory();
        DecorationPlacer decorationPlacer2 = new DecorationPlacer(gf);

        System.out.println(decorationPlacer1.placeDecorations());
        System.out.println(decorationPlacer2.placeDecorations());
    }
}
