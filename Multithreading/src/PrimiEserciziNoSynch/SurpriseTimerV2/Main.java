package PrimiEserciziNoSynch.SurpriseTimerV2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Bomb> bombs = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            bombs.add(new Bomb("Bomba" + (i + 1), new Random().nextInt(10)));
        }

        for (Bomb b : bombs) b.start();

        // quando premo INVIO interrompo b1
        new Scanner(System.in).nextLine();
        for (Bomb b : bombs) b.interrupt();

        //Ora gestiamo N bombe.
        //Lancaite N bombe con tempo random
        //!!!) la prima bomba che finisce fa terminare tute le altre e chiude il programma,
        //Come sempre, se premo INVIO devo interrompere TUTTE le bombe.

    }
}
