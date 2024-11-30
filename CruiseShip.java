import java.util.Random;

public class CruiseShip extends Vehicle {
    private int passengerCapacity;
    private int maxPassengerCapacity;
    private double damageLevel;

    private static final Random random = new Random();

    public CruiseShip(String name, int maxPassengerCapacity) {
        super(name);
        this.passengerCapacity = 0;
        this.maxPassengerCapacity = maxPassengerCapacity;
        this.damageLevel = 0.0;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getDamageLevel() {
        return damageLevel;
    }

    @Override
    public void displayInfo() {
        System.out.println("Cruise Ship: " + getName() +
                ", Current Passengers: " + passengerCapacity +
                ", Max Capacity: " + maxPassengerCapacity +
                ", Damage Level: " + String.format("%.1f", damageLevel) + "%.");

    }

    public void boardPassengers() {
        int newPassengers = random.nextInt(300); // Board up to 300 passengers
        if (passengerCapacity + newPassengers > maxPassengerCapacity) {
            newPassengers = maxPassengerCapacity - passengerCapacity; // Limit to max capacity
        }

        passengerCapacity += newPassengers;
        damageLevel += newPassengers * 0.01; // Increase damage slightly
        System.out.println("Boarded " + newPassengers + " passengers.");
    }


    public void repair() {
        double repairAmount = random.nextDouble() * 25; // Repair between 0 and 25%
        damageLevel -= repairAmount;
        if (damageLevel < 5) {  // Ensure a minimum damage level of 5%
            damageLevel = 5;
        }
        System.out.println("Repaired " + String.format("%.1f", repairAmount) + "%. Current damage level: " + String.format("%.1f", damageLevel) + "%.");
    }

}
