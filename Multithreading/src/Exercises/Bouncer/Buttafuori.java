package Exercises.Bouncer;

public class Buttafuori {
    private int personePresenti;
    private final int CAPACITA_LOCALE;

    private final int ETA_MINIMA_LOCALE;

    public Buttafuori(int capacitaLocale, int etaMinimaLocale) {
        CAPACITA_LOCALE = capacitaLocale;
        ETA_MINIMA_LOCALE = etaMinimaLocale;
        personePresenti = 0;
    }

    public synchronized void addPerson(int etaUtente) throws InterruptedException {
        while (personePresenti >= CAPACITA_LOCALE) wait();

        if (etaUtente < ETA_MINIMA_LOCALE) {
            System.out.println(Thread.currentThread().getName() + " non rispetta i requisiti minimi d'età. Deve esesre respinto.");
            Thread.currentThread().interrupt();
            return;
        }

        personePresenti++;
        System.out.println(Thread.currentThread().getName() + " entra nel locale. Persone all'interno: " + personePresenti);
    }

    public synchronized void removePerson() {
        personePresenti--;
        System.out.println(Thread.currentThread().getName() + " è uscito dal locale. Persone all'interno: " + personePresenti);
        notifyAll();
    }
}
