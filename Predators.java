public class Predators extends Animals{
    private String correspondingPreys;

    public Predators(int health, boolean fertility, boolean presence, String race, boolean status, String correspondingPreys) {
        super(health, fertility, presence, race, status);
        this.correspondingPreys = correspondingPreys;
    }

    public String getCorrespondingPreys() {
        return correspondingPreys;
    }

    public void setCorrespondingPreys(String correspondingPreys) {
        this.correspondingPreys = correspondingPreys;
    }

    public void hunt() {
        System.out.println("The predator is hunting its prey: " + correspondingPreys);
    }
}
