package Exercises.WarehousePatientConsumer;

import java.util.Random;

public class Operaio extends Thread {

    private static final int PACCHI = 5;

    private final Magazzino magazzino;
    private final Random random;

    public Operaio(String nome, Magazzino magazzino) {
        super(nome);
        this.magazzino = magazzino;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= PACCHI; i++) {
                Thread.sleep(1000 + random.nextInt(2000));
                System.out.println("[" + getName() + "] prepara pacco " + i);
                magazzino.deposita(i, this);
            }
            System.out.println("[" + getName() + "] ha terminato.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
