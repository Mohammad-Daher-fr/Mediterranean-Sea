public class CruiseShip extends Vehicle{
    private int passengerCapacity;

    public CruiseShip(String name, int passengerCapacity) {
        super(name);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Cruise Ship: " + getName() +
                ", Capacity: " + passengerCapacity + " passengers.");
    }
}
