import java.util.Random;

public class Prey extends Animal implements Survivor {
    private String preyType;
    private String correspondingPredator;
    private boolean school;

    public Prey(int health, boolean fertility, boolean presence, String preyType, String correspondingPredator, boolean school) {
        super(health, fertility, presence, correspondingPredator, school);
        this.preyType = preyType;
        this.correspondingPredator = correspondingPredator;
        this.school = school;
    }

    public String getPreyType() {
        return preyType;
    }
    public String getCorrespondingPredator() {
        return correspondingPredator;
    }

    public void setCorrespondingPredator(String correspondingPredator) {
        this.correspondingPredator = correspondingPredator;
    }

    public boolean isSchool() {
        return school;
    }

    public void setSchool(boolean school) {
        this.school = school;
    }

    public void fight() {
        // Implementation for fighting
        System.out.println("Prey is fighting.");
    }

    @Override
    public void consumeResources(int foodAmount) {
        validatePresence("eat");
        System.out.println("The " + preyType + " eats " + foodAmount + " units of food.");
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Prey prey = new Prey(getHealth() / 2, true, true,getPreyType(),getCorrespondingPredator(),isSchool());
            System.out.println("A new "+preyType+" was born! With health " + prey.getHealth() + ".");
            return prey;
        } else {
            System.out.println("The "+preyType+" cannot reproduce.");
            return null;
        }
    }

    @Override
    public boolean move(){
        validatePresence("move to a new location");
        System.out.println("The "+preyType+" moves to a new location.");
        return true;
    }

    @Override
    public void die() {
        // Implementation for death
        System.out.println(preyType+" has died.");
        setPresence(false);
    }

    @Override
    public void disappear() {
        // Implementation for disappearance
        System.out.println(preyType+" has disappeared.");
        setPresence(false);
    }

    public int flee() {
        Random random = new Random();
        int amount = random.nextInt(100) + 1; // entre 1 et 100 inclus
        System.out.println(amount +" of "+preyType+" is fleeing " +  " from "+ correspondingPredator+".");
        return amount;
    }

}