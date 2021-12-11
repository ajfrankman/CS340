import factory_interface.FactoryInterface;
import factory_interface.TableclothPatternInterface;
import factory_interface.WallHangingInterface;
import factory_interface.YardOrnamentInterface;

public class GroundhogdayFactory implements FactoryInterface {
    @Override
    public TableclothPatternInterface tableCloth() {
        return new GroundhogdayTableclothProvider();
    }

    @Override
    public WallHangingInterface wallHanging() {
        return new GroundhogdayWallHangingProvider();
    }

    @Override
    public YardOrnamentInterface yardOrnament() {
        return new GroundhogdayYardOrnamentProvider();
    }
}
