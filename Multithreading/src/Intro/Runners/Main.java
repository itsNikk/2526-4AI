package Intro.Runners;

import java.util.ArrayList;
import java.util.Random;

//CTRL + D : duplica riga
public class Main {
    public static void main(String[] args) {
        Atleta atleta = new Atleta("Andrea");
        Atleta atleta2 = new Atleta("Luca");
        Atleta atleta3 = new Atleta("Daniele");

        ArrayList<Atleta> athletes = new ArrayList<>();

        athletes.add(atleta);
        athletes.add(atleta2);
        athletes.add(atleta3);

        for (Atleta elem : athletes) elem.start();

        // il thread che chiama questo metodo, attende l'altro thread termine per avanzare
        try {
            Thread.sleep(1000 + (int) (Math.random() * 1000));
            boolean r = new Random().nextBoolean();
            if (r) atleta.interrupt(); else atleta2.interrupt();

            atleta2.join();
            atleta.join();

            Giuria.printBoard(athletes);

            System.out.println("Gara conclusa");

        } catch (InterruptedException e) {
            //Che si fa?
        }
    }
}
