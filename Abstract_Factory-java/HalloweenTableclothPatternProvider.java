import factory_interface.TableclothPatternInterface;

public class HalloweenTableclothPatternProvider implements TableclothPatternInterface {

    @Override
    public String getTablecloth() {
        return "ghosts and skeletons";
    }
}
