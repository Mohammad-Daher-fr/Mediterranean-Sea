//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        // Initialize the ecosystem components
//        MediterraneanSea MedSea = new MediterraneanSea();
//        Climate climate = new Climate();
//        List<LivingSpecies> livingSpecies = new ArrayList<>();
//        List<Vehicle> vehicles = new ArrayList<>();
//
//        // Add some initial entities to the ecosystem
//        livingSpecies.add(new Plants());
//        livingSpecies.add(new Humans());
//        livingSpecies.add(new Animals());
//        vehicles.add(new OilTanker());
//        vehicles.add(new CruiseShip());
//        vehicles.add(new FishingTrawler());
//
//        // Simulate the ecosystem for a number of cycles
//        for (int i = 0; i < 10; i++) {
//            // Simulate climate effects
//            climate.overheat();
//            climate.toxicity();
//            climate.speciesDisappearance();
//            climate.speciesAppearance();
//
//            // Simulate actions of living beings
//            for (LivingSpecies ls : livingSpecies) {
//                ls.eat();
//                ls.reproduce();
//                ls.move();
//                ls.die();
//                ls.disappear();
//            }
//
//            // Simulate actions of vehicles
//            for (Vehicle v : vehicles) {
//                if (vehicles instanceof OilTanker) {
//                    ((OilTanker) vehicles).spill();
//                } else if (vehicles instanceof CruiseShip) {
//                    ((CruiseShip) vehicles).pollute();
//                } else if (vehicles instanceof FishingTrawler) {
//                    ((FishingTrawler) vehicles).fish();
//                    ((FishingTrawler) vehicles).exploit();
//                }
//            }
//
//            // Print the status of the ecosystem
//            MedSea.printStatus();
//        }
//    }
//}