public class Preys extends Animals {
    private String correspondingPredator;
    private boolean school;

    public Preys(int health, boolean fertility, boolean presence, String correspondingPredator, boolean school) {
        super(health, fertility, presence, correspondingPredator, school);
        this.correspondingPredator = correspondingPredator;
        this.school = school;
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

    public void hide() {
        // Implementation for hiding
        System.out.println("Prey is hiding.");
    }

    public void migrate() {
        // Implementation for migrating
        System.out.println("Prey is migrating.");
    }

    public void fight() {
        // Implementation for fighting
        System.out.println("Prey is fighting.");
    }

    @Override
    public void eat(int foodAmount) {
        // Implementation for eating
        System.out.println("Prey is eating " + foodAmount + " units of food.");
    }

    @Override
    public LivingSpecies reproduce() {
        // Implementation for reproduction
        System.out.println("Prey is reproducing.");
        return new Preys(getHealth(), isFertility(), isPresence(), correspondingPredator, school);
    }

    @Override
    public void die() {
        // Implementation for death
        System.out.println("Prey has died.");
        setPresence(false);
    }

    @Override
    public void disappear() {
        // Implementation for disappearance
        System.out.println("Prey has disappeared.");
        setPresence(false);
    }
}