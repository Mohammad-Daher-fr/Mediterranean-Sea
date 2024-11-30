import java.util.Random;

public class OilTanker extends Vehicle {
    private double oilCapacity;
    private double maxOilCapacity;
    private double damageLevel;

    private static final Random random = new Random();

    public OilTanker(String name, double maxOilCapacity) {
        super(name);
        this.oilCapacity = 0;
        this.maxOilCapacity = maxOilCapacity;
        this.damageLevel = 0.0;
    }

    public double getOilCapacity() {
        return oilCapacity;
    }

    public double getDamageLevel() {
        return damageLevel;
    }

    @Override
    public void displayInfo() {
        System.out.println("Oil Tanker: " + getName() +
                ", Current Oil: " + String.format("%.1f", oilCapacity) + " barrels" +
                ", Max Capacity: " + String.format("%.1f", maxOilCapacity) + " barrels" +
                ", Damage Level: " + String.format("%.1f", damageLevel) + "%.");
    }

    public void drillOil() {
        if (damageLevel >= 100) {
            System.out.println("The tanker is too damaged to drill oil.");
            return;
        }

        double oilDrilled = random.nextDouble() * 200; // Drill between 0 and 200 barrels
        if (oilCapacity + oilDrilled > maxOilCapacity) {
            oilDrilled = maxOilCapacity - oilCapacity; // Limit to max capacity
        }

        oilCapacity += oilDrilled;
        damageLevel += oilDrilled * 0.02; // Increase damage slightly
        System.out.println("Drilled " + String.format("%.1f", oilDrilled) + " barrels of oil.");

    }

    public void repair() {
        double repairAmount = random.nextDouble() * 30; // Repair between 0 and 30%
        damageLevel -= repairAmount;
        if (damageLevel < 5) {  // Ensure a minimum damage level of 5%
            damageLevel = 5;
        }
        System.out.println("Repaired " + String.format("%.1f", repairAmount) + "%. Current damage level: " + String.format("%.1f", damageLevel) + "%.");
    }

}
