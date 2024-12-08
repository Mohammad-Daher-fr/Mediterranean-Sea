public class Crustaceans extends Animals implements Survivor,Reproducers {
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
    public LivingSpecies reproduce() {
        // Implementation of reproduction behavior
        validatePresence("reproduce");
        System.out.println("The crustacean reproduces.");
        return new Crustaceans(getHealth(), isFertility(), isPresence(), this.getType(), isStatus(), this.edible);
    }

    @Override
    public void consumeResources(int amount) {
        validatePresence("consume resources");
        System.out.println("Crustacean is filtering " + amount + " units of nutrients from the water.");
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
        validatePresence("hunting");
        System.out.println("The crustacean is hunting.");
    }

    @Override
    public void flee() {
        // Implementation of fleeing behavior
        validatePresence("flee");
        System.out.println("The crustacean flees.");
    }
}