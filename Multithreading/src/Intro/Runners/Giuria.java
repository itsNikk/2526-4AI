package Intro.Runners;

import java.util.ArrayList;

public class Giuria {

    public static void printBoard(ArrayList<Atleta> atleti) {

        // Ordinamento manuale (selection sort)
        for (int i = 0; i < atleti.size() - 1; i++) {
            for (int j = i + 1; j < atleti.size(); j++) {

                Atleta a = atleti.get(i);
                Atleta b = atleti.get(j);

                if (a.getRaceCompleted() && b.getRaceCompleted()) {
                    if (a.getRaceTime() > b.getRaceTime()) {
                        atleti.set(i, b);
                        atleti.set(j, a);
                    }
                }
            }
        }

        System.out.println("--- CLASSIFICA FINALE ---");

        int posizione = 1;
        for (Atleta a : atleti) {
            if (a.getRaceCompleted()) {
                System.out.println(posizione + ". " + a.getName() +
                        " - tempo: " + a.getRaceTime() + " ms");
                posizione++;
            }
        }

        System.out.println("--- ATLETI RITIRATI ---");

        for (Atleta a : atleti) {
            if (a.getDisqualified()) {
                System.out.println("- " + a.getName());
            }
        }
    }
}
