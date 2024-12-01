public class Predators {
    private String correspondingPreys;

    public Predators(String correspondingPreys) {
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
