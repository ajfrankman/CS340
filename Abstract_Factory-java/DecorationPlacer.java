import factory_interface.FactoryInterface;
import factory_interface.TableclothPatternInterface;
import factory_interface.WallHangingInterface;
import factory_interface.YardOrnamentInterface;

public class DecorationPlacer {

    // FIXME use dependency inversion to remove these hard-coded dependencies
    private TableclothPatternInterface tableclothPattern;
    private WallHangingInterface wallHanging;
    private YardOrnamentInterface yardOrnament;

    public DecorationPlacer(FactoryInterface factory) {
        tableclothPattern = factory.tableCloth();
        wallHanging = factory.wallHanging();
        yardOrnament = factory.yardOrnament();
    }

    public String placeDecorations() {
        return "Everything was ready for the party. The " + yardOrnament.getOrnament()
                + " was in front of the house, the " + wallHanging.getHanging()
                + " was hanging on the wall, and the tablecloth with " + tableclothPattern.getTablecloth()
                + " was spread over the table.";
    }
}
