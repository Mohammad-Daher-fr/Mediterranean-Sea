public class LivingSpecies {
    private int health;
    private boolean fertility;
    private boolean presence;

    public LivingSpecies(int health, boolean fertility, boolean presence) {
        this.health = health;
        this.fertility = fertility;
        this.presence = presence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isFertility() {
        return fertility;
    }

    public void setFertility(boolean fertility) {
        this.fertility = fertility;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void eat(int foodAmount) {
        if (presence) {
            health++;
            System.out.println("The species has eaten " + foodAmount + " units of food. Health is now " + health + ".");
        } else {
            System.out.println("The species is not present and cannot eat.");
        }
    }

    public LivingSpecies reproduce() {
        if (presence && fertility) {
            LivingSpecies newSpecies = new LivingSpecies(health/2, true, true);
            System.out.println("A new species has been created with health."+getHealth());
            return newSpecies;
        } else {
            System.out.println("The species cannot reproduce.");
            return null;
        }
    }

    public void die() {
        presence = false;
        health = 0;
        System.out.println("The species has died.");
    }

    public void disappear() {
        presence = false;
        System.out.println("The species has disappeared.");
    }
}
