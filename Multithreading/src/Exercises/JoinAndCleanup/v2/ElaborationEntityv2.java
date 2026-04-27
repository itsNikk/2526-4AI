package Exercises.JoinAndCleanup.v2;

import java.util.Random;

public class ElaborationEntityv2 extends Thread {

    private final Random random;

    public ElaborationEntityv2(String nome) {
        super(nome);
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            int durata = 3000 + random.nextInt(10000);
            System.out.println("[" + getName() + "] avviato (durata prevista: " + durata + "ms)");
            Thread.sleep(durata);
            System.out.println("[" + getName() + "] completato.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + getName() + "] interrotto prima del completamento.");
        }
    }
}
