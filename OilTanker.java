public class OilTanker extends Vehicle{
    private double oilCapacity; // in barrels

    public OilTanker(String name, double oilCapacity) {
        super(name);
        this.oilCapacity = oilCapacity;
    }

    public double getOilCapacity() {
        return oilCapacity;
    }

    public void setOilCapacity(double oilCapacity) {
        this.oilCapacity = oilCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Cruise Ship: " + getName() +
                ", Oil Capacity: " + oilCapacity + " barrels.");
    }
}
