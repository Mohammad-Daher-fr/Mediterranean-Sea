import java.util.ArrayList;
import java.util.List;

public abstract class Animal extends LivingSpecies implements Reproducers,Movable{
    private String race;
    private boolean status;

    public Animal(int health, boolean fertility, boolean presence, String race, boolean status) {
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
    public void die() {
        validatePresence("die");
        System.out.println("The " + race + " dies.");
        setPresence(false);
        setHealth(0);
        setStatus(false);
    }

    @Override
    public void disappear() {
        validatePresence("disappear");
        System.out.println("The " + race + " disappears.");
        setPresence(false);
        setStatus(false);
    }

    public int hunt() {
        validatePresence("hunt");
        // Par défaut, l'animal ne chasse pas.
        System.out.println("This animal does not hunt.");
        return 0;
    }

    public int flee() {
        validatePresence("flee");
        // Par défaut, l'animal ne fuit pas ou ne sait pas comment fuir
        System.out.println("This animal does not flee.");
        return 0;
    }
}