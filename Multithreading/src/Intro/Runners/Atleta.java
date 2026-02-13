package Intro.Runners;

public class Atleta extends Thread {

    private long startTime;
    private long endTime;
    private boolean disqualified;
    private boolean raceCompleted;

    public Atleta(String nome) {
        super(nome); //setName(name);
        this.disqualified = false;
        this.raceCompleted = false;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + ": Step " + (i + 1));
                sleep(300 + (int) (Math.random() * 500));
            }
            raceCompleted = true;
            endTime = System.currentTimeMillis();
        } catch (InterruptedException e) {
            //che si fa quando qualcuno chiama interrupt su un qualunque Thread Atleta?
            disqualified = true;
            System.out.println(getName() + " ritirato / qualificato");
        }
    }

    public long getRaceTime() {
        return endTime - startTime;
    }

    public boolean getDisqualified() {
        return disqualified;
    }

    public boolean getRaceCompleted() {
        return raceCompleted;
    }
}
