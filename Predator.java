import java.util.Random;

public class Predator extends Animal {
    private String predatorName;
    private String correspondingPreys;

    public Predator(int health, boolean fertility, boolean presence, String race, boolean status, String predatorName, String correspondingPreys) {
        super(health, fertility, presence, race, status);
        this.predatorName = predatorName;
        this.correspondingPreys = correspondingPreys;
    }

    public String getPredatorName() {
        return predatorName;
    }

    public String getCorrespondingPreys() {
        return correspondingPreys;
    }

    public void setCorrespondingPreys(String correspondingPreys) {
        this.correspondingPreys = correspondingPreys;
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Predator predator = new Predator(getHealth() / 2, true, true,getRace(),isStatus(), getPredatorName(),getCorrespondingPreys());
            System.out.println("A new "+predatorName+" was born! With health " + predator.getHealth() + ".");
            return predator;
        } else {
            System.out.println("The "+predatorName+" cannot reproduce.");
            return null;
        }
    }

    @Override
    public boolean move(){
        validatePresence("move to a new location");
        System.out.println("The "+predatorName+" moves to a new location.");
        return true;
    }

    @Override
    public void die() {
        validatePresence("die");
        System.out.println("The "+predatorName+" died.");
        setPresence(false);
        setHealth(0);
        setStatus(false);
    }

    @Override
    public void disappear() {
        validatePresence("disappear");
        System.out.println("The "+predatorName+" disappeared.");
        setPresence(false);
        setStatus(false);
    }

    public int hunt() {
        validatePresence("hunt");
        Random random = new Random();
        int amount = random.nextInt(20) + 1; // entre 1 et 20 inclus
        System.out.println("The "+predatorName+" has eaten " + amount + " units of "+ correspondingPreys+".");
        return amount;
    }

}

