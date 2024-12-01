public class Animals extends LivingSpecies {
    private String race;
    private boolean status;

    public Animals(int health, boolean fertility, boolean presence, String race, boolean status) {
        super(health, fertility, presence);
        this.race = race;
        this.status = status;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void eat(int foodAmount) {
        // Implementation of eating behavior
        System.out.println("The animal eats " + foodAmount + " units of food.");
    }

    @Override
    public LivingSpecies reproduce() {
        // Implementation of reproduction behavior
        System.out.println("The animal reproduces.");
        return new Animals(getHealth(), isFertility(), isPresence(), this.race, this.status);
    }

    @Override
    public void die() {
        // Implementation of dying behavior
        System.out.println("The animal dies.");
        setPresence(false);
    }

    @Override
    public void disappear() {
        // Implementation of disappearing behavior
        System.out.println("The animal disappears.");
        setPresence(false);
    }

    public void hunting() {
        // Implementation of hunting behavior
        System.out.println("The animal is hunting.");
    }

    public void flee() {
        // Implementation of fleeing behavior
        System.out.println("The animal flees.");
    }
}