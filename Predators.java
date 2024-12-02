public class Predators extends Animals{
    private String correspondingPreys;

    public Predators(int health, boolean fertility, boolean presence, String race, boolean status, String correspondingPreys) {
        super(health, fertility, presence, race, status);
        this.correspondingPreys = correspondingPreys;
    }

    public String getCorrespondingPreys() {
        return correspondingPreys;
    }

    public void setCorrespondingPreys(String correspondingPreys) {
        this.correspondingPreys = correspondingPreys;
    }

    @Override
    public void eat(int foodAmount) {
        if (isPresence()) {
            setHealth(getHealth() + foodAmount);
            System.out.println("The predator has eaten " + foodAmount + " units of food. Health is now " + getHealth() + ".");
        } else {
            System.out.println("The predator is not present and cannot eat.");
        }
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Predators predator = new Predators(getHealth() / 2, true, true,getRace(),isStatus(), getCorrespondingPreys());
            System.out.println("A new predator has been created with health " + predator.getHealth() + ".");
            return predator;
        } else {
            System.out.println("The predator cannot reproduce.");
            return null;
        }
    }

    @Override
    public void die() {
        setPresence(false);
        setHealth(0);
        System.out.println("The predator has died.");
    }

    @Override
    public void disappear() {
        setPresence(false);
        System.out.println("The predator has disappeared.");
    }

    public void hunt() {
        System.out.println("The predator is hunting its prey: " + correspondingPreys);
    }

}

