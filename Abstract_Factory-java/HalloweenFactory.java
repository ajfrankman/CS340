import factory_interface.FactoryInterface;
import factory_interface.TableclothPatternInterface;
import factory_interface.WallHangingInterface;
import factory_interface.YardOrnamentInterface;

public class HalloweenFactory implements FactoryInterface {
    @Override
    public TableclothPatternInterface tableCloth() {
        return new HalloweenTableclothPatternProvider();
    }

    @Override
    public WallHangingInterface wallHanging() {
        return new HalloweenWallHangingProvider();
    }

    @Override
    public YardOrnamentInterface yardOrnament() {
        return new HalloweenYardOrnamentProvider();
    }
}
