public class Crustaceans extends Animal implements Survivor {
    private String crustaceanName;
    private boolean edible;

    public Crustaceans(int health, boolean fertility, boolean presence, String race, boolean status, String crustaceanName, boolean edible) {
        super(health, fertility, presence, race, status);
        this.edible = edible;
    }

    public String getCrustaceanName() {
        return crustaceanName;
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
        return new Crustaceans(getHealth(), isFertility(), isPresence(), this.getRace(), isStatus(), getCrustaceanName(),this.edible);
    }

    @Override
    public boolean move(){
        validatePresence("move to a new location");
        System.out.println("The "+crustaceanName+" moves to a new location.");
        return true;
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



}