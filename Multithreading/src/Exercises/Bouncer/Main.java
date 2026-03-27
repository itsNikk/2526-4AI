package Exercises.Bouncer;

import java.util.Random;

public class Main {

    public static final int ETA_MINIMA_LOCALE = 18;
    public static final int CAPACITA_LOCALE = 5;
    public static final int NUM_UTENTI = 10;

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Buttafuori buttafuori = new Buttafuori(CAPACITA_LOCALE, ETA_MINIMA_LOCALE);
        Utente[] utenti = new Utente[NUM_UTENTI];

        for (int i = 0; i < utenti.length; i++) {
            utenti[i] = new Utente("Utente" + (i + 1), r.nextInt(17, ETA_MINIMA_LOCALE + 1), buttafuori);
            System.out.println(utenti[i]);
        }

        for (Utente utente : utenti) utente.start();
        for (Utente utente : utenti) utente.join();

        System.out.println("Il locale chiude. Serata conclusa :)");
    }
}
