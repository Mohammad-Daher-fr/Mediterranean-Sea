public class Humans extends LivingSpecies{
    private String job;

    public Humans(int health, boolean fertility, boolean presence, String job) {
        super(health, fertility, presence);
        this.job = job;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void eat(int foodAmount) {
        if(isPresence()){
            setHealth(getHealth() + foodAmount);
            System.out.println(job + " has eaten "+ foodAmount +" units of food.Health is now "+getHealth()+".");
        } else {
            System.out.println(job + " is not present and cannot eat.");
        }
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Humans human = new Humans(getHealth() / 2, true, true, getJob());
            System.out.println("A new "+ human.job +" has been created with health " + human.getHealth() + ".");
            return human;
        } else {
            System.out.println(job + " cannot reproduce.");
            return null;
        }
    }

    @Override
    public void die() {
        setPresence(false);
        setHealth(0);
        System.out.println(job + " has died.");
    }

    @Override
    public void disappear() {
        setPresence(false);
        System.out.println(job + " has disappeared.");
    }

    public void fishing() {
        System.out.println(job + " is fishing.");
    }

    public void pollute(Climate climate, float amount) {
        climate.incrementPollution(amount);
        System.out.println(job + " has polluted the environment by " + amount + " units.");
    }


    public void regulate() {
        System.out.println(job + " is regulating the environment.");
    }

    public void visit() {
        System.out.println(job + " is visiting a new place.");
    }
}
