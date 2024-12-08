import java.util.ArrayList;
import java.util.List;

public class Humans extends LivingSpecies implements Movable,Reproducers,Survivor,Polluters{
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
    public void move() {
        validatePresence("move to a new location");
        System.out.println(job + " is moving to a new location.");
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


    public void regulate() {
        validatePresence("regulate");
        System.out.println(job + " is regulating the environment.");
    }

    public void visit() {
        validatePresence("visit");
        System.out.println(job + " is visiting a new place.");
    }
}
