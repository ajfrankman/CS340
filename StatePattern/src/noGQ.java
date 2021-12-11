public class noGQ extends GumballState {
    public void addGumballs (GumballMachine gumballMachine, int count) {
        gumballMachine.setGumballCount(gumballMachine.getGumballCount() + count);
        gumballMachine.setCurrentState(new GQ());
    }
    public void insertQuarter (GumballMachine gumballMachine) {
        System.out.println("Only one quarter at a time please");
    }
    public void removeQuarter (GumballMachine gumballMachine) {
        gumballMachine.setQuarterPresent(false);
        gumballMachine.setCurrentState(new noGnoQ());
    }

    public void turnHandle(GumballMachine gumballMachine) {
        System.out.println("sorry no gumballs!");
    }
}
