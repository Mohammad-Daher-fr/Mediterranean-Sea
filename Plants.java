public class Plants extends LivingSpecies implements Survivor,Reproducers{
    private float density;

    public Plants(int health, boolean fertility, boolean presence, float density) {
        super(health, fertility, presence);
        this.density = density;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    @Override
    public void consumeResources(int amount) {
        if (!isPresence()) {
            throw new IllegalStateException("Plant is not present and cannot absorb resources.");
        }
        System.out.println("Plant is absorbing " + amount + " units of nutrients.");
    }

    @Override
    public LivingSpecies reproduce() {
        // Implementation for plant reproduction
        System.out.println("Plant is reproducing.");
        return new Plants(getHealth(), isFertility(), isPresence(), density);
    }

    @Override
    public void die() {
        // Implementation for plant death
        System.out.println("Plant has died.");
        setPresence(false);
    }

    @Override
    public void disappear() {
        // Implementation for plant disappearance
        System.out.println("Plant has disappeared.");
        setPresence(false);
    }

    public void beingEaten() {
        // Implementation for being eaten
        System.out.println("Plant is being eaten.");
    }

    public void shelter() {
        // Implementation for shelter
        System.out.println("Plant is providing shelter.");
    }
}