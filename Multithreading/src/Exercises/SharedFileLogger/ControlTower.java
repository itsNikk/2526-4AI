package Exercises.SharedFileLogger;

public class ControlTower {

    private final int piste;
    private int libere;

    public ControlTower(int piste) {
        this.piste  = piste;
        this.libere = piste;
    }

    public synchronized int assignStrip(Thread t) throws InterruptedException {
        while (libere == 0) wait();

        int pista = piste - libere + 1;
        libere--;
        return pista;
    }

    public synchronized void freeStrip(Thread t) {
        libere++;
        notifyAll();
    }
}
