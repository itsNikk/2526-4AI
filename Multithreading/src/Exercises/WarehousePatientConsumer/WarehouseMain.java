package Exercises.WarehousePatientConsumer;

public class WarehouseMain {
    private static final int NUM_OPERAI = 3;
    private static final int PACCHI_CIASCUNO = 5;
    private static final int CAPACITA_MAGAZZINO = 4;

    public static void main(String[] args) throws InterruptedException {

        Magazzino magazzino = new Magazzino(CAPACITA_MAGAZZINO);
        int totale = NUM_OPERAI * PACCHI_CIASCUNO;

        Operaio[] operai = new Operaio[NUM_OPERAI];
        for (int i = 0; i < NUM_OPERAI; i++) operai[i] = new Operaio("Operaio-" + (i + 1), magazzino);
        Corriere corriere = new Corriere(magazzino, totale);

        for (Operaio o : operai) o.start();
        corriere.start();

        for (Operaio o : operai) o.join();
        corriere.join();

        System.out.println("Simulazione terminata.");
    }
}
