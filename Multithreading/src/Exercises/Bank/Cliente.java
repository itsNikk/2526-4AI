package Exercises.Bank;

import java.util.Random;

public class Cliente extends Thread {

    private final Sportello sportello;
    private final Random random;
    private boolean servito;

    public Cliente(String nome, Sportello sportello) {
        super(nome);
        this.sportello = sportello;
        this.random = new Random();
        this.servito = false;
    }

    public boolean isServito() {
        return servito;
    }

    @Override
    public void run() {
        try {
            System.out.println("[" + getName() + "] in attesa di un cassiere...");
            boolean ottenuto = sportello.occupy(this);
            if (!ottenuto) {
                System.out.println("[" + getName() + "] rinuncia: timeout scaduto.");
                return;
            }
            servito = true;
            System.out.println("[" + getName() + "] in servizio...");
            Thread.sleep(2000 + random.nextInt(2000));
            sportello.release(this);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
