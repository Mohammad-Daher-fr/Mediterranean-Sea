public class Main {
    public static void main(String[] args) {
        OilTanker oilTanker = new OilTanker("Poseidon", 1000);
        CruiseShip cruiseShip = new CruiseShip("Ocean Pearl", 500);
        FishingTrawler fishingTrawler = new FishingTrawler("Sea Harvest", 50);

        // Oil Tanker Operations
        System.out.println("\n--- Oil Tanker Operations ---");
        oilTanker.drillOil();
        oilTanker.drillOil();
        oilTanker.repair();

        // Cruise Ship Operations
        System.out.println("\n--- Cruise Ship Operations ---");
        cruiseShip.boardPassengers();
        cruiseShip.boardPassengers();
        cruiseShip.repair();

        // Fishing Trawler Operations
        System.out.println("\n--- Fishing Trawler Operations ---");
        fishingTrawler.fish();
        fishingTrawler.fish();
        fishingTrawler.repair();

        // Final Status
        System.out.println("\nFinal Status:");
        oilTanker.displayInfo();
        cruiseShip.displayInfo();
        fishingTrawler.displayInfo();
    }
}
