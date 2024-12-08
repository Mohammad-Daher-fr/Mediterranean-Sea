import java.util.Random;

public class FishingTrawler extends Vehicle implements Movable {
    private double fishCapacity;
    private double maxFishCapacity;
    private double damageLevel;

    private static final Random random = new Random();

    public FishingTrawler(String name, double maxFishCapacity) {
        super(name);
        this.fishCapacity = 0;
        this.maxFishCapacity = maxFishCapacity;
        this.damageLevel = 0.0;
    }

    public double getFishCapacity() {
        return fishCapacity;
    }

    public double getDamageLevel() {
        return damageLevel;
    }

    @Override
    public void displayInfo() {
        System.out.println("Fishing Trawler: " + getName() +
                ", Current Fish: " + String.format("%.1f", fishCapacity) + " tons" +
                ", Max Capacity: " + String.format("%.1f", maxFishCapacity) + " tons" +
                ", Damage Level: " + String.format("%.1f", damageLevel) + "%.");

    }

    @Override
    public void move() {
        System.out.println("Fishing boat is moving to a new fishing area.");
    }

    public void fish() {
        double fishCaught = random.nextDouble() * 20; // Catch up to 20 tons
        if (damageLevel >= 100) {
            System.out.println("The trawler is too damaged to fish.");
            return;
        }

        if (fishCapacity + fishCaught > maxFishCapacity) {
            fishCaught = maxFishCapacity - fishCapacity; // Limit to max capacity
        }

        fishCapacity += fishCaught;
        damageLevel += fishCaught * 0.05; // Increase damage slightly
        System.out.println("Caught " + String.format("%.1f", fishCaught) + " tons of fish.");

    }

    public void repair() {
        double repairAmount = random.nextDouble() * 20; // Repair between 0 and 20%
        damageLevel -= repairAmount;
        if (damageLevel < 5) {  // Ensure a minimum damage level of 5%
            damageLevel = 5;
        }
        System.out.println("Repaired " + String.format("%.1f", repairAmount) + "%. Current damage level: " + String.format("%.1f", damageLevel) + "%.");
    }

}
