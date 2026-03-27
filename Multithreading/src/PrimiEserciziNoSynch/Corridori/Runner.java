package PrimiEserciziNoSynch.Corridori;


import java.util.Random;


public class Runner extends Thread {
    private final int MAXLAPS = 5;
    private Random r;

    public Runner(String name) {
        super(name);
        r = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < MAXLAPS; i++) {
            System.out.println(getName() + " sta correndo...");
            try {
                sleep(r.nextInt(400) + 100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
            }
        }
        System.out.println(getName() + " ha tagliato il traguardo!");
    }
}
