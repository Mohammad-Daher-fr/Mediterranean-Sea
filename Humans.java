import java.util.ArrayList;
import java.util.List;

public class Humans extends LivingSpecies implements Reproducers,Survivor,Polluters{
    private String job;
    private List<Animals> caughtFish;

    public Humans(int health, boolean fertility, boolean presence, String job) {
        super(health, fertility, presence);
        this.job = job;
        this.caughtFish = new ArrayList<Animals>();
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public List<Animals> getCaughtFish() {
        return caughtFish;
    }


    @Override
    public void consumeResources(int amount) {
        validatePresence("eat");
        if(isPresence()){
            setHealth(getHealth() + amount);
            System.out.println(job + " has eaten "+ amount +" units of food.Health is now "+getHealth()+".");
        }
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Humans human = new Humans(getHealth() / 2, true, true, getJob());
            System.out.println("A new "+ human.job +" has been created with health " + human.getHealth() + ".");
            return human;
        } else {
            System.out.println(job + " cannot reproduce.");
            return null;
        }
    }

    @Override
    public void die() {
        setPresence(false);
        setHealth(0);
        System.out.println(job + " has died.");
    }

    @Override
    public void disappear() {
        setPresence(false);
        System.out.println(job + " has disappeared.");
    }

    public void fishing(String fishType) {
        validatePresence("fish");

        Animals caughtFish = Animals.catchFish(fishType); // remove un poisson de la population

        if (caughtFish != null) {
            System.out.println(job + " has caught a " + caughtFish.getType() + "!");
        } else {
            System.out.println("No fish left to catch.");
        }
    }

    @Override
    public void pollute(Climate climate, double amount) {
        validatePresence("pollute");
        climate.incrementPollution(amount);
        System.out.println(job + " has polluted the environment by " + amount + " units.");
    }

    private String getFishForSpring(Climate climate) {
        double pollution = climate.getPollution();
        if (pollution < 20) {
            return "Trout"; // Les poissons sensibles préfèrent les eaux propres
        } else if (pollution < 50) {
            return "Bass"; // Espèces adaptées à une pollution modérée
        } else {
            System.out.println("Pollution too high for fishing in spring.");
            return null;
        }
    }

    private String getFishForSummer(Climate climate) {
        double temperature = climate.getTemperature();
        if (temperature > 30) {
            return "Tilapia"; // Les poissons adaptés à l'eau chaude
        } else if (temperature > 20) {
            return "Catfish"; // Espèces qui aiment l'eau modérément chaude
        } else {
            System.out.println("No suitable fish for the summer temperature.");
            return null;
        }
    }

    private String getFishForAutumn(Climate climate) {
        double pollution = climate.getPollution();
        if (pollution < 30) {
            return "Salmon"; // Les saumons migrent souvent en automne
        } else {
            return "Pike"; // Espèces résistantes à des niveaux de pollution plus élevés
        }
    }

    private String getFishForWinter(Climate climate) {
        double temperature = climate.getTemperature();
        if (temperature < 0) {
            return "Cod"; // Espèces adaptées aux eaux froides
        } else if (temperature < 5) {
            return "Herring"; // Espèces supportant des eaux légèrement froides
        } else {
            return null; // Pas de poisson adapté
        }
    }




    public void regulate(Climate climate) {
        validatePresence("regulate");

        Season currentSeason = climate.getCurrentSeason(); // Obtenir la saison actuelle
        System.out.println(job + " is regulating fishing based on the current climate: " + currentSeason);

        String targetFish;

        switch (currentSeason) {
            case SPRING:
                // tuna
                targetFish = getFishForSpring(climate);
                break;
            case SUMMER:
                // pieuvre
                targetFish = getFishForSummer(climate);
                break;
            case AUTUMN:
                // requin
                targetFish = getFishForAutumn(climate);
                break;
            case WINTER:
                // sardines
                targetFish = getFishForWinter(climate);
                break;
            default:
                targetFish = null;
        }

        if (targetFish != null) {
            System.out.println("Targeting fish for the season: " + targetFish);
            fishing(targetFish); // Pêcher le type de poisson défini pour la saison
        } else {
            System.out.println("No suitable fish detected for this season.");
        }
    }


}
