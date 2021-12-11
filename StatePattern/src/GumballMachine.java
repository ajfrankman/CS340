public class GumballMachine {
    double money;
    int gumballCount;
    Boolean quarterPresent;

    GumballState currentState;

    public GumballMachine(double money, int gumballCount, Boolean quarterPresent) {
        this.money = money;
        this.gumballCount = gumballCount;
        this.quarterPresent = quarterPresent;
        if (gumballCount >0 && quarterPresent) {
            currentState = new GQ();
        } else if (gumballCount < 0 && quarterPresent) {
            currentState = new noGQ();
        } else if (gumballCount > 0  && !quarterPresent) {
            currentState = new GnoQ();
        } else {
            currentState = new noGnoQ();
        }
    }

    public void addGumballs(int count) {
        currentState.addGumballs(this, count);
    }

    public void insertQuarter() {
        currentState.insertQuarter(this);
    }

    public void removeQuarter() {
        currentState.removeQuarter(this);

    }

    public void turnHandle() {
        currentState.turnHandle(this);
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getGumballCount() {
        return gumballCount;
    }

    public void setGumballCount(int gumballCount) {
        this.gumballCount = gumballCount;
    }

    public Boolean getQuarterPresent() {
        return quarterPresent;
    }

    public void setQuarterPresent(Boolean quarterPresent) {
        this.quarterPresent = quarterPresent;
    }

    public GumballState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GumballState currentState) {
        this.currentState = currentState;
    }
}
