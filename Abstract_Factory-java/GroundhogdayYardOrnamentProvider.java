import factory_interface.YardOrnamentInterface;

public class GroundhogdayYardOrnamentProvider implements YardOrnamentInterface {
    @Override
    public String getOrnament() {
        return "Beware of Ground Hog sign";
    }
}
