import factory_interface.WallHangingInterface;

public class HalloweenWallHangingProvider implements WallHangingInterface {

    @Override
    public String getHanging() {
        return "spider-web";
    }
}
