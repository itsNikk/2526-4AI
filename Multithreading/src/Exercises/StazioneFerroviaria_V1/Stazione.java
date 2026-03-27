package Exercises.StazioneFerroviaria_V1;

public class Stazione {
    private int numeroBinari;
    private boolean[] binariOccupati;
    private String nomeStazione;

    public Stazione(String nomeStazione, int numeroBinari) {
        this.numeroBinari = numeroBinari;
        this.binariOccupati = new boolean[numeroBinari];
        this.nomeStazione = nomeStazione;
        //FONDAMENTALE!
        // Same as --> Arrays.fill(binariOccupati, false);
        for (int i = 0; i < binariOccupati.length; i++) {
            binariOccupati[i] = false;
        }
    }

    public synchronized int arrive(int codiceTreno) throws InterruptedException {
        while (areAllPlatformsOccupied()) {
            System.out.println("Tutti i binari sono occupati. Il treno " + codiceTreno + " aspetta.");
            wait();
        }

        int numeroBinarioDaAssegnare = findFreePlatform();
        binariOccupati[numeroBinarioDaAssegnare] = true;
        return numeroBinarioDaAssegnare;
    }

    public synchronized void depart(int codiceTreno, int numeroBinario) {
        binariOccupati[numeroBinario] = false;
        System.out.println("Treno " + codiceTreno + " parte dal binario " + numeroBinario);
        notifyAll();
    }

    private int findFreePlatform() {
        for (int i = 0; i < binariOccupati.length; i++) {
            if (!binariOccupati[i]) return i;
        }
        return -1;
    }

    private boolean areAllPlatformsOccupied() {
        for (boolean binario : binariOccupati) {
            if (!binario) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stazione " + nomeStazione;
    }
}
