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

}