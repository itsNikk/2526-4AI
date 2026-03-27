package PrimiEserciziNoSynch.AutoCorsa;

public class AutoDaCorsa implements Runnable {
    private String nome;
    private int velocita = 0; // Velocità iniziale
    private final int PIT_STOP_INTERVAL = 5; // Ogni 5 iterazioni
    private final int PIT_STOP_DURATA = 2000; // 2 secondi

    public AutoDaCorsa(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        int iterazioni = 0;
        while (true) {
            //Si potrebbe clampare (limitare) la velocità in un range [0,MAX].. ma è poco rilevante per l'esercizio
            velocita += 20;
            iterazioni++;

            System.out.println(nome + " - Velocità attuale: " + velocita + " km/h");

            // Pit stop ogni 5 iterazioni
            if (iterazioni % PIT_STOP_INTERVAL == 0) {
                System.out.println(nome + " entra ai box per un pit stop! 🏁");
                try {
                    Thread.sleep(PIT_STOP_DURATA); // Simula il pit stop
                } catch (InterruptedException e) {
                    System.out.println(nome + " ha terminato la gara!");
                    break;
                }
            }

            // Pausa ed eventuale terminazione
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(nome + " ha terminato la gara!");
                break;
            }
        }
    }
}