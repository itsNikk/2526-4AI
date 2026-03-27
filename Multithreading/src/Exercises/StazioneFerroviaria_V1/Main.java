package Exercises.StazioneFerroviaria_V1;

public class Main {
    public static void main(String[] args) {
        Stazione stazione = new Stazione("Oppalalà", 3);

        Treno[] treni = new Treno[10];
        for (int i = 0; i < treni.length; i++) treni[i] = new Treno(i + 1, stazione);

        for (Treno treno : treni) treno.start();
    }
}
