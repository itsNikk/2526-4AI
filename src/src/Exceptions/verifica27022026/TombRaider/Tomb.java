package Exceptions.verifica27022026.TombRaider;

import java.util.Random;

public class Tomb {
    private Explorer explorer;
    private Random random;
    private int totalCorridors;

    public Tomb(Explorer explorer, int totalCorridors) {
        this.explorer = explorer;
        this.random = new Random();
        this.totalCorridors = totalCorridors;
    }

    public void explore() throws InterruptedException {
        for (int currentCorridor = 1; currentCorridor <= totalCorridors; currentCorridor++) {

            if (explorer.hasNoTorches()) {
                throw new OutOfTorchesException("Torce esaurite al corridoio " + currentCorridor);
            }


            if (random.nextDouble() < 0.40) {
                int lost = 1 + random.nextInt(3);
                try {
                    //Si, lancio per gestire... strano ma è quello richiesto ;)
                    throw new TrapException("Trappola! Perse " + lost + " torce.");
                } catch (TrapException e) {
                    explorer.setTorches(explorer.getTorches() - lost);
                    System.out.println("Corridoio " + currentCorridor + ": TRAPPOLA! Perse " + lost + " torce. Torce rimanenti: " + explorer.getTorches() + ".");
                }
            } else {
                explorer.setTorches(explorer.getTorches() - 1);
                System.out.println("Corridoio " + currentCorridor + ": avanzato. Torce rimanenti: " + explorer.getTorches() + ".");
            }

            if (explorer.hasNoTorches()) {
                throw new OutOfTorchesException("Torce esaurite al corridoio " + currentCorridor);
            }

            Thread.sleep(1000);

        }
    }
}