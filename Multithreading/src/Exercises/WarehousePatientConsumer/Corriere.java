package Exercises.WarehousePatientConsumer;

import java.util.Random;

public class Corriere extends Thread {

    private static final int MAX_TENTATIVI_FALLITI = 3;

    private final Magazzino magazzino;
    private final int totaleAtteso;
    private final Random random;

    public Corriere(Magazzino magazzino, int totaleAtteso) {
        super("Corriere");
        this.magazzino = magazzino;
        this.totaleAtteso = totaleAtteso;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            int consegnati = 0;
            int tentativiFalliti = 0;

            while (consegnati < totaleAtteso && tentativiFalliti < MAX_TENTATIVI_FALLITI) {
                Integer pacco = magazzino.preleva();
                if (pacco == null) {
                    tentativiFalliti++;
                    System.out.println("[CORRIERE] Timeout #" + tentativiFalliti
                            + ": magazzino vuoto. Riprovo...");
                    continue;
                }
                tentativiFalliti = 0;
                System.out.println("[CORRIERE] Consegna pacco " + pacco + "...");
                Thread.sleep(2000 + random.nextInt(2000));
                System.out.println("[CORRIERE] Pacco " + pacco + " consegnato.");
                consegnati++;
            }

            if (tentativiFalliti >= MAX_TENTATIVI_FALLITI) {
                System.out.println("[CORRIERE] Produttori terminati. Fine consegne.");
            } else {
                System.out.println("[CORRIERE] Tutti i pacchi consegnati.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
