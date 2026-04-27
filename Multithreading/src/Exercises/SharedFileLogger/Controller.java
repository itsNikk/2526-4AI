package Exercises.SharedFileLogger;

import java.util.Random;

public class Controller extends Thread {

    private static final int ATTERRAGGI = 4;

    private final ControlTower torre;
    private final SharedLogger logger;
    private final Random random;

    public Controller(String nome, ControlTower torre, SharedLogger logger) {
        super(nome);
        this.torre  = torre;
        this.logger = logger;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= ATTERRAGGI; i++) {
                int pista = torre.assegnaPista(this);
                logger.writeToFile("autorizza atterraggio #" + i + " su pista " + pista);

                Thread.sleep(2000 + random.nextInt(2000));
                logger.writeToFile("atterraggio #" + i + " completato, pista " + pista + " libera");

                torre.liberaPista(this);
            }
            logger.writeToFile("turno completato.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
