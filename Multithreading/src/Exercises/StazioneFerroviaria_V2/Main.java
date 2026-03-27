package Exercises.StazioneFerroviaria_V2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Binario[] binari = {
                new Binario(1),
                new Binario(2),
                new Binario(3),
                new Binario(4),
        };
        Stazione stazione = new Stazione("Oppalalà", binari);

        Treno[] treni = new Treno[10];
        for (int i = 0; i < treni.length; i++) treni[i] = new Treno(i + 1, stazione);

        for (Treno treno : treni) treno.start();
        for (Treno treno : treni) treno.join();
        System.out.println("Fine giornata :)");
    }
}
