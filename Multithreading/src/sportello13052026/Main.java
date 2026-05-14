package sportello13052026;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        //CTRL+ALT+T
        Magazzino magazzino = new Magazzino(5);
        // create 20 produttodri
        ArrayList<Fornitore> f = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //f.add(new Fornitore(magazzino));
        }

        for (Fornitore fornitore : f) fornitore.start();
        for (Fornitore fornitore : f) fornitore.join();


    }
}
