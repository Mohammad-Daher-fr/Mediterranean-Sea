public class Crustaceans extends Animals {
    private boolean edible;

    public Crustaceans(int health, boolean fertility, boolean presence, String race, boolean status, boolean edible) {
        super(health, fertility, presence, race, status);
        this.edible = edible;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public void eat(int foodAmount) {
        // Implementation of eating behavior
        System.out.println("The crustacean eats " + foodAmount + " units of food.");
    }

    @Override
    public LivingSpecies reproduce() {
        // Implementation of reproduction behavior
        System.out.println("The crustacean reproduces.");
        return new Crustaceans(getHealth(), isFertility(), isPresence(), getRace(), isStatus(), this.edible);
    }

    @Override
    public void die() {
        // Implementation of dying behavior
        System.out.println("The crustacean dies.");
        setPresence(false);
    }

    @Override
    public void disappear() {
        // Implementation of disappearing behavior
        System.out.println("The crustacean disappears.");
        setPresence(false);
    }

    @Override
    public void hunting() {
        // Implementation of hunting behavior
        System.out.println("The crustacean is hunting.");
    }

    @Override
    public void flee() {
        // Implementation of fleeing behavior
        System.out.println("The crustacean flees.");
    }
}