public class GQ extends GumballState{

    public void addGumballs (GumballMachine gumballMachine, int count) {
        gumballMachine.setGumballCount(gumballMachine.getGumballCount() + count);
    }
    public void insertQuarter (GumballMachine gumballMachine) {
        System.out.println("Only one quarter at a time please");
    }
    public void removeQuarter (GumballMachine gumballMachine) {
        gumballMachine.setQuarterPresent(false);
        gumballMachine.setCurrentState(new GnoQ());
    }

    public void turnHandle(GumballMachine gumballMachine) {
        System.out.println("here is a gumball sir");
        gumballMachine.setQuarterPresent(false);
        gumballMachine.setMoney(gumballMachine.getMoney() + .25);
        gumballMachine.setGumballCount(gumballMachine.getGumballCount() - 1);
        if (gumballMachine.getGumballCount() < 1) {
            gumballMachine.setCurrentState(new noGnoQ());
        } else {
            gumballMachine.setCurrentState(new GnoQ());
        }
    }
}
