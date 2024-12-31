import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Définir les limites spatiales de la mer Méditerranée
        float[] spatialLimits = {36.0f, 42.0f, -5.0f, 36.0f}; // Exemple de limites géographiques

        // Créer une instance de la mer Méditerranée
        MediterraneanSea mediterraneanSea = new MediterraneanSea(1.5f, 1000000f, spatialLimits);

        // Créer une instance de climat
        Climate climate = new Climate(Season.SPRING, 20.0);

        // Créer des instances d'espèces vivantes
        List<LivingSpecies> livingSpeciesList = new ArrayList<>();
        livingSpeciesList.add(new Plant(100, true, true, 10.0f, false));
        livingSpeciesList.add(new Human(100, true, true, "Fisherman"));
        livingSpeciesList.add(new Predator(200, true, true, "Shark", true, "Fish"));
        livingSpeciesList.add(new Prey(50, true, true, "Sardine", true, "Shark", true));
        livingSpeciesList.add(new Crustacean(30, true, true, "Crab", true, true));

        // Créer des instances de véhicules
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new FishingTrawler("Trawler", 100.0));
        vehicleList.add(new OilTanker("Tanker", 500.0));
        vehicleList.add(new CruiseShip("Cruise Ship", 3000));

        // Simuler une année complète
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            climate.setSeason(season);
            System.out.println("\nSeason: " + season);
            System.out.println(climate);

            // Simuler des actions pour chaque saison
            for (LivingSpecies species : livingSpeciesList) {
                if (species instanceof Human) {
                    ((Human) species).fishing("Tuna");
                } else if (species instanceof Predator) {
                    ((Predator) species).hunt();
                } else if (species instanceof Prey) {
                    ((Prey) species).flee();
                } else if (species instanceof Crustacean) {
                    ((Crustacean) species).consumeResources(5);
                } else if (species instanceof Plant) {
                    ((Plant) species).consumeResources(10);
                }
            }

            for (Vehicle vehicle : vehicleList) {
                if (vehicle instanceof FishingTrawler) {
                    ((FishingTrawler) vehicle).fish();
                } else if (vehicle instanceof OilTanker) {
                    ((OilTanker) vehicle).drillOil();
                } else if (vehicle instanceof CruiseShip) {
                    ((CruiseShip) vehicle).boardPassengers();
                }
            }

            // Afficher les informations mises à jour
            for (LivingSpecies species : livingSpeciesList) {
                species.displayInfos();
            }

            for (Vehicle vehicle : vehicleList) {
                vehicle.displayInfo();
            }

            // Demander à l'utilisateur s'il veut ajouter de nouvelles instances
            System.out.println("Voulez-vous ajouter de nouvelles instances pour la saison suivante ? (oui/non)");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("oui")) {
                addNewInstances(scanner, livingSpeciesList, vehicleList);
            }
        }

        scanner.close();
    }

    private static void addNewInstances(Scanner scanner, List<LivingSpecies> livingSpeciesList, List<Vehicle> vehicleList) {
        System.out.println("Ajouter une nouvelle espèce vivante (1) ou un nouveau véhicule (2) ?");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        if (choice == 1) {
            System.out.println("Choisir le type d'espèce vivante : 1. Plante, 2. Humain, 3. Prédateur, 4. Proie, 5. Crustacé");
            int speciesType = Integer.parseInt(scanner.nextLine().trim());

            switch (speciesType) {
                case 1:
                    livingSpeciesList.add(new Plant(100, true, true, 10.0f, false));
                    break;
                case 2:
                    livingSpeciesList.add(new Human(100, true, true, "Fisherman"));
                    break;
                case 3:
                    livingSpeciesList.add(new Predator(200, true, true, "Shark", true, "Fish"));
                    break;
                case 4:
                    livingSpeciesList.add(new Prey(50, true, true, "Sardine", true, "Shark", true));
                    break;
                case 5:
                    livingSpeciesList.add(new Crustacean(30, true, true, "Crab", true, true));
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } else if (choice == 2) {
            System.out.println("Choisir le type de véhicule : 1. Chalutier, 2. Pétrolier, 3. Navire de croisière");
            int vehicleType = Integer.parseInt(scanner.nextLine().trim());

            switch (vehicleType) {
                case 1:
                    vehicleList.add(new FishingTrawler("Trawler", 100.0));
                    break;
                case 2:
                    vehicleList.add(new OilTanker("Tanker", 500.0));
                    break;
                case 3:
                    vehicleList.add(new CruiseShip("Cruise Ship", 3000));
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } else {
            System.out.println("Choix invalide.");
        }
    }
}