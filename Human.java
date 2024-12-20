import java.util.ArrayList;
import java.util.List;

public class Human extends LivingSpecies implements Survivor,Polluters{
    private String job;

    public Human(int health, boolean fertility, boolean presence, String job) {
        super(health, fertility, presence);
        this.job = job;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void consumeResources(int amount) {
        validatePresence("eat");
        setHealth(getHealth() + amount);
        System.out.println(job + " has eaten "+ amount +" units of food.Health is now "+getHealth()+".");
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Human human = new Human(getHealth() / 2, true, true, getJob());
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

    public String fishing(String fishType) {
        validatePresence("fish");
        System.out.println(job + " has caught a " + fishType+ "!");
        return  fishType;
    }

    @Override
    public void pollute(Climate climate, double amount) {
        validatePresence("pollute");
        climate.incrementPollution(amount);
        System.out.println(job + " has polluted the environment by " + amount + " units.");
    }


    public void regulate(Climate climate) {
        validatePresence("regulate");

        Season currentSeason = climate.getCurrentSeason(); // Obtenir la saison actuelle
        System.out.println(job + " is regulating fishing based on the current climate: " + currentSeason);

        String targetFish;

        switch (currentSeason) {
            case SPRING:
                targetFish = "Tuna";
                break;
            case SUMMER:
                targetFish = "Octopus";
                break;
            case AUTUMN:
                targetFish = "Shark";
                break;
            case WINTER:
                targetFish = "Sardine";
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
