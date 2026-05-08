package Exercises.WaitingRoomWithShifts;

public class WaitingRoomMain {

    private static final int NUM_PAZIENTI = 6;
    private static final int NUM_TURNI = 2;

    public static void main(String[] args) throws InterruptedException {

        SalaAttesa sala = new SalaAttesa();

        Paziente[] pazienti = new Paziente[NUM_PAZIENTI];
        for (int i = 0; i < NUM_PAZIENTI; i++) pazienti[i] = new Paziente("Paziente-" + (i + 1), sala);
        Medico medico = new Medico(sala, NUM_TURNI);

        for (Paziente p : pazienti) p.start();
        medico.start();

        for (Paziente p : pazienti) p.join();
        medico.join();

        System.out.println("Simulazione terminata.");
    }
}
