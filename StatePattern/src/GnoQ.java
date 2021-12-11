public class GnoQ extends GumballState{

    public void addGumballs (GumballMachine gumballMachine, int count) {
        gumballMachine.setGumballCount(gumballMachine.getGumballCount() + count);
    }
    public void insertQuarter (GumballMachine gumballMachine) {
        gumballMachine.setQuarterPresent(true);
        gumballMachine.setCurrentState(new GQ());
    }
    public void removeQuarter (GumballMachine gumballMachine) {
        System.out.println("You can take something that doesn't exist");
    }

    public void turnHandle(GumballMachine gumballMachine) {
        System.out.println("You need to insert a quarter.");
    }
}
