package Exercises.WaitingRoomWithShifts;

public class SalaAttesa {

    private int inAttesa;
    private int turnoAttivo;
    private int turnoChiamato;

    public SalaAttesa() {
        this.inAttesa = 0;
        this.turnoAttivo = 0;
        this.turnoChiamato = -1;
    }

    //Metodo del paziente: registra l'arrivo, si mette in coda e attende la chiamata.
    public synchronized void checkInAndWait(Thread t) throws InterruptedException {
        int mioTurno = turnoAttivo;
        inAttesa++;
        System.out.println("[SALA] " + t.getName() + " arriva"
                + " (turno " + mioTurno + ", presenti: " + inAttesa + ")");
        while (turnoChiamato < mioTurno) {
            wait();
        }
        System.out.println("[SALA] " + t.getName() + " risponde alla chiamata.");
    }

    //Metodo del medico: attende, poi chiama tutti.
    public synchronized int waitAndCall() throws InterruptedException {
        wait(10000);
        int chiamati = inAttesa;
        inAttesa = 0;
        turnoChiamato = turnoAttivo;
        turnoAttivo++;
        System.out.println("[MEDICO] Turno " + turnoChiamato
                + ": chiama " + chiamati + " pazient"
                + (chiamati == 1 ? "e" : "i") + ".");
        notifyAll();
        return chiamati;
    }
}
