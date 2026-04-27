package Exercises.JoinAndCleanup;

public class Main {

    private static final int NUM_PROCESSI = 5;
    private static final long TIMEOUT_MS = 7000;
    private static final String ENTITY_PREFIX = "ENT";

    public static void main(String[] args) throws InterruptedException {

        ElaborationEntity[] entities = new ElaborationEntity[NUM_PROCESSI];
        for (int i = 0; i < NUM_PROCESSI; i++) entities[i] = new ElaborationEntity(ENTITY_PREFIX + "-" + (i + 1));

        for (ElaborationEntity p : entities) p.start();

        int completati = 0;
        int interrotti = 0;

        // ;) ;) ;)
        for (ElaborationEntity p : entities) {
            p.join(TIMEOUT_MS);
            if (p.isAlive()) {
                System.out.println("[MAIN] " + p.getName() + " non ha completato entro " + TIMEOUT_MS + "ms: interrotto.");
                p.interrupt();
                interrotti++;
            } else completati++;
        }

        System.out.println("Completati: " + completati + " | Interrotti: " + interrotti);
        System.out.println("Simulazione terminata.");
    }
}
