public class StateMachine {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(0, 5, false);

        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        System.out.println("$" + gumballMachine.getMoney());
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.addGumballs(1);
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle();
        System.out.println("$" + gumballMachine.getMoney());
    }
}
