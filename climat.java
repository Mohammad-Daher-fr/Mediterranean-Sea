import java.util.Random;
import java.util.Scanner;

enum Saison {
    PRINTEMPS, ÉTÉ, AUTOMNE, HIVER
}

public class climat {
    private Saison saisonActuelle;
    private double temperature;
    private double humidite;
    private double pollution;
    private final Random random = new Random();

    public climat(Saison saison, double pollution) {
        this.saisonActuelle = saison;
        this.pollution = Math.max(0, Math.min(100, pollution));
        ajusterConditions();
    }

    public double getPollution() {
        return pollution;
    }

    public void setPollution(double pollution) {
        this.pollution = Math.max(0, Math.min(100, pollution));
        ajusterConditions();
    }

    public void setSaison(Saison saison) {
        this.saisonActuelle = saison;
        ajusterConditions();
    }

    private void ajusterConditions() {
        // Ajuster la pollution selon la saison
        ajusterPollutionSelonSaison();

        // Ajuster la température et l'humidité selon la saison et la pollution
        switch (saisonActuelle) {
            case PRINTEMPS:
                temperature = randomInRange(15, 25) + effetPollutionSurTemperature();
                humidite = calculerHumidite(temperature, 60, 80);
                break;
            case ÉTÉ:
                temperature = randomInRange(25, 35) + effetPollutionSurTemperature();
                humidite = calculerHumidite(temperature, 40, 60);
                break;
            case AUTOMNE:
                temperature = randomInRange(10, 20) + effetPollutionSurTemperature();
                humidite = calculerHumidite(temperature, 50, 70);
                break;
            case HIVER:
                temperature = randomInRange(-5, 5) + effetPollutionSurTemperature();
                humidite = calculerHumidite(temperature, 30, 50);
                break;
        }
        humidite = Math.max(0, Math.min(100, humidite)); // Limiter l'humidité entre 0 et 100
    }

    private void ajusterPollutionSelonSaison() {
        switch (saisonActuelle) {
            case PRINTEMPS:
                pollution = pollution + randomInRange(-5, 5); // Légère variation de pollution en printemps
                break;
            case ÉTÉ:
                pollution = pollution + randomInRange(10, 20); // Pollution plus élevée en été
                break;
            case AUTOMNE:
                pollution = pollution + randomInRange(-5, 5); // Pollution légèrement plus basse en automne
                break;
            case HIVER:
                pollution = pollution - randomInRange(5, 15); // Pollution réduite en hiver
                break;
        }
        pollution = Math.max(0, Math.min(100, pollution)); // Limiter la pollution entre 0 et 100
    }

    private double effetPollutionSurTemperature() {
        return pollution * 0.05;
    }

    private double calculerHumidite(double temperature, double minHumidite, double maxHumidite) {
        // L'humidité dépend de la température et de la pollution
        double variationTemperature = (temperature - 20) * 0.5; // Ajustement de l'humidité basé sur la température
        double humiditeSansPollution = randomInRange(minHumidite, maxHumidite);
        double effetPollution = pollution * 0.02;

        // Ajouter l'effet de la température et de la pollution sur l'humidité
        double humiditeAvecEffets = humiditeSansPollution + variationTemperature - effetPollution;
        return Math.max(0, Math.min(100, humiditeAvecEffets));
    }

    private double randomInRange(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    @Override
    public String toString() {
        return String.format("Climat actuel -> Saison: %s, Température: %.1f°C, Humidité: %.1f%%, Pollution: %.1f",
                saisonActuelle, temperature, humidite, pollution);
    }

//    // Méthode main
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("=== Simulation de Climat ===");
//
//        // Permet à l'utilisateur d'entrer plusieurs saisons
//        String saisonStr;
//        while (true) {
//            System.out.println("\nEntrez une saison:");
//            saisonStr = scanner.nextLine().toUpperCase();
//
//            if (saisonStr.equals("QUITTER")) {
//                break;
//            }
//
//            try {
//                // Conversion de la saisie en Saison
//                Saison saisonChoisie = Saison.valueOf(saisonStr);
//
//                // Création d'un climat avec la saison choisie
//                climat climat = new climat(saisonChoisie, 30);  // Pollution initiale fixée à 30
//                System.out.println("\nCaractéristiques pour la saison " + saisonStr + " :");
//                System.out.println(climat);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Saison invalide. Veuillez entrer une des saisons suivantes : PRINTEMPS, ÉTÉ, AUTOMNE, HIVER.");
//            }
//        }
//        scanner.close();
//    }
}
