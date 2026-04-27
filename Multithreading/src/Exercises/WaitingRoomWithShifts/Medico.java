package Exercises.WaitingRoomWithShifts;

public class Medico extends Thread {

    private final SalaAttesa sala;
    private final int turniTotali;

    public Medico(SalaAttesa sala, int turniTotali) {
        super("Medico");
        this.sala = sala;
        this.turniTotali = turniTotali;
    }

    @Override
    public void run() {
        try {
            for (int turno = 0; turno < turniTotali; turno++) {
                System.out.println("[MEDICO] Attende il prossimo turno...");
                int chiamati = sala.waitAndCall();
                if (chiamati > 0) {
                    System.out.println("[MEDICO] Visita in corso (" + chiamati + " pazienti)...");
                    Thread.sleep(3000);
                    System.out.println("[MEDICO] Visita completata.");
                }
            }
            System.out.println("[MEDICO] Ambulatorio chiuso.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
