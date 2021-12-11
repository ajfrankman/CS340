public class noGnoQ extends GumballState {
    public void addGumballs (GumballMachine gumballMachine, int count) {
        gumballMachine.setGumballCount(gumballMachine.getGumballCount() + count);
        gumballMachine.setCurrentState(new GnoQ());
    }
    public void insertQuarter (GumballMachine gumballMachine) {
        gumballMachine.setQuarterPresent(true);
        gumballMachine.setCurrentState(new noGQ());
    }
    public void removeQuarter (GumballMachine gumballMachine) {
        System.out.println("You can't take what isn't there.");
    }

    public void turnHandle(GumballMachine gumballMachine) {
        System.out.println("no money AND no gumballs. You must be a special kind of stupid.");
    }
}
