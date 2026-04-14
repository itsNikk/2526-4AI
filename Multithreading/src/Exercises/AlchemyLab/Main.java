package Exercises.AlchemyLab;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //Rilancio al main solo per semplicità/chiarezza del codice, già sappiamo che non si fa.
    public static void main(String[] args) throws InterruptedException {
        final int NUM_FORNACI = 2;
        final int NUM_TAVOLI = 2;
        final int NUM_CAPPE = 2;

        //Qualche nome a caso... minimo 8
        String[] names = {"Gandalf", "Saruman", "Ermete", "Morgana", "Merlino", "Luca", "NOME7", "NOME8"};
        List<Alchimista> alchimisti = new ArrayList<>();
        Laboratorio laboratorio = new Laboratorio(NUM_FORNACI, NUM_TAVOLI, NUM_CAPPE);

        for (String name : names) alchimisti.add(new Alchimista(name, laboratorio));
        for (Alchimista alchimista : alchimisti) alchimista.start();
        for (Alchimista alchimista : alchimisti) alchimista.join();

        System.out.println("Il laboratorio chiude");


    }
}

