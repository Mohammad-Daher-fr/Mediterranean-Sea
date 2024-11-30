public abstract class LivingSpecies {
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

    public abstract void eat(int foodAmount);

    public abstract LivingSpecies reproduce();

    public abstract void die();

    public abstract void disappear();
}
