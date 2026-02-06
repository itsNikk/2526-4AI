package Intro.Runners;

public class Atleta extends Thread {

    private long startTime;
    private long endTime;
    private boolean disqualified;

    public Atleta(String nome) {
        super(nome); //setName(name);
        this.disqualified = false;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(getName() + ": Step " + (i + 1));
                sleep(300 + (int) (Math.random() * 500));
            } catch (InterruptedException e) {
                //che si fa quando qualcuno mi interrompe?
                disqualified = true;
                System.out.println(getName() + " ritirato / qualificato");
                break;
            }
        }

        endTime = System.currentTimeMillis();
    }

    public long getRaceTime() {
        return endTime - startTime;
    }

    public boolean getDisqualified() {
        return disqualified;
    }
}
