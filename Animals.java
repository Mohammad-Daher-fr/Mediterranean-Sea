import java.util.ArrayList;
import java.util.List;

public class Animals extends LivingSpecies implements Reproducers,Movable{
    private String type;
    private boolean status;
    private static List<Animals> fishPopulation = new ArrayList<>();

    public Animals(int health, boolean fertility, boolean presence, String type, boolean status) {
        super(health, fertility, presence);
        this.type = type;
        this.status = status;
        if(type.equals("Fish")) {
            fishPopulation.add(this);// add into the population si c'est un poisson
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static int getFishPopulationSize() {
        return fishPopulation.size();
    }

    public static Animals catchFish(String type) {
        for (Animals fish : fishPopulation) { // Parcourt tous les poissons dans fishPopulation
            if (fish.getType().equalsIgnoreCase(type)) {
                fishPopulation.remove(fish);
                return fish;
            }
        }
        System.out.println("No fish of type " + type + " found!");
        return null;
    }

    @Override
    public LivingSpecies reproduce() {
        // Implementation of reproduction behavior
        System.out.println("The animal reproduces.");
        return new Animals(getHealth(), isFertility(), isPresence(), this.type, this.status);
    }

    @Override
    public void consumeResources(int foodAmount) {
        validatePresence("consume resources");
        System.out.println("The animal consumes " + foodAmount + " units of food.");
    }

    @Override
    public boolean move() {
        validatePresence("move to a new location");
        System.out.println("Animal is moving to a new location.");
        return true;
    }

    @Override
    public void die() {
        // Implementation of dying behavior
        System.out.println("The animal dies.");
        setPresence(false);
        if (type.equalsIgnoreCase("Fish")) {
            fishPopulation.remove(this); // remove le poisson de la population
        }
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