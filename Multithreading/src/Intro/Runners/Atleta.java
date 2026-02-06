package Intro.Runners;

public class Atleta extends Thread {

    private long startTime;
    private long endTime;

    public Atleta(String nome) {
        super(nome); //setName(name);
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
                System.out.println(getName() + " ritirato / qualificato");
                break;
            }
        }

        endTime = System.currentTimeMillis();
    }

    public long getRaceTime() {
        return endTime - startTime;
    }
}
