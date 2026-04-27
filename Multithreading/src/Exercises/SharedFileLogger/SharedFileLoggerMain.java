package Exercises.SharedFileLogger;

import java.io.IOException;

public class SharedFileLoggerMain {

    private static final int NUM_CONTROLLORI = 3;
    private static final int NUM_PISTE = 3;

    public static void main(String[] args) throws InterruptedException {

        SharedLogger logger;
        try {
            logger = new SharedLogger("log.txt");
        } catch (IOException e) {
            System.err.println("Impossibile aprire il file di log: " + e.getMessage());
            return;
        }

        ControlTower torre = new ControlTower(NUM_PISTE);

        Controller[] controllori = new Controller[NUM_CONTROLLORI];
        for (int i = 0; i < NUM_CONTROLLORI; i++) controllori[i] = new Controller("CTR-" + (i + 1), torre, logger);

        for (Controller c : controllori) c.start();
        for (Controller c : controllori) c.join();

        logger.close();
        System.out.println("Simulazione terminata. Log scritto su log.txt");
    }
}
