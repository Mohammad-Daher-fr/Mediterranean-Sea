public class FishingTrawler extends Vehicle{
    private double fishCapacity; // in tons

    public FishingTrawler(String name, double fishCapacity) {
        super(name);
        this.fishCapacity = fishCapacity;
    }

    public double getFishCapacity() {
        return fishCapacity;
    }

    public void setFishCapacity(double fishCapacity) {
        this.fishCapacity = fishCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Cruise Ship: " + getName() +
                ", Fish Capacity: " + fishCapacity + " tons.");
    }
}
