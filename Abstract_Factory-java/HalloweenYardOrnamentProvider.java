import factory_interface.YardOrnamentInterface;

public class HalloweenYardOrnamentProvider implements YardOrnamentInterface {

    @Override
    public String getOrnament() {
        return "jack-o-lantern";
    }
}
