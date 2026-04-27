package Exercises.WaitingRoomWithShifts;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Paziente extends Thread {

    private final SalaAttesa sala;
    private final Random random;

    public Paziente(String nome, SalaAttesa sala) {
        super(nome);
        this.sala = sala;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            //int ritardo = random.nextInt(4000);
            int ritardo = ThreadLocalRandom.current().nextInt(4000);
            System.out.println("[" + getName() + "] arriva tra " + ritardo + "ms...");
            Thread.sleep(ritardo);
            sala.checkInAndWait(this);
            System.out.println("[" + getName() + "] visita completata.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
