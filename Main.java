import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Définir les limites spatiales de la mer Méditerranée
        float[] spatialLimits = {36.0f, 42.0f, -5.0f, 36.0f}; // Exemple de limites géographiques

        // Créer une instance de la mer Méditerranée
        MediterraneanSea mediterraneanSea = new MediterraneanSea(1.5f, 1000000f, spatialLimits);

        // Créer une instance de climat
        Climate climate = new Climate(Season.SPRING, 20.0);

        // Créer des instances d'espèces vivantes
        Plant algae = new Plant(100, true, true, 10.0f, false);
        Human fisherman = new Human(100, true, true, "Fisherman");
        Predator shark = new Predator(200, true, true, "Shark", true, "Fish");
        Prey sardine = new Prey(50, true, true, "Sardine", true, "Shark", true);
        Crustacean crab = new Crustacean(30, true, true, "Crab", true, true);

        // Créer des instances de véhicules
        FishingTrawler trawler = new FishingTrawler("Trawler", 100.0);
        OilTanker tanker = new OilTanker("Tanker", 500.0);
        CruiseShip cruiseShip = new CruiseShip("Cruise Ship", 3000);

        // Ajouter des entités à une liste pour gestion
        List<LivingSpecies> livingSpeciesList = new ArrayList<>();
        livingSpeciesList.add(algae);
        livingSpeciesList.add(fisherman);
        livingSpeciesList.add(shark);
        livingSpeciesList.add(sardine);
        livingSpeciesList.add(crab);

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(trawler);
        vehicleList.add(tanker);
        vehicleList.add(cruiseShip);

        // Simuler une année complète
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            climate.setSeason(season);
            System.out.println("\nSeason: " + season);
            System.out.println(climate);

            // Simuler des actions pour chaque saison
            fisherman.fishing("Tuna");
            shark.hunt();
            sardine.flee();
            crab.consumeResources(5);
            algae.consumeResources(10);

            trawler.fish();
            tanker.drillOil();
            cruiseShip.boardPassengers();

            // Afficher les informations mises à jour
            for (LivingSpecies species : livingSpeciesList) {
                species.displayInfos();
            }

            for (Vehicle vehicle : vehicleList) {
                vehicle.displayInfo();
            }
        }
    }
}