package Exercises.ReentrantLockAndConditions.Airport;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Terminal {
    //CTRL+D= duplica riga
    private int gateNazionali;
    private int gateInterazionali;

    private int gateInterazionaliLiberi;

    private final ReentrantLock lock;
    private Condition attendiInternazionale;
    private Condition attendiNazionale;

    public Terminal(int gateNazionali, int gateInterazionali) {
        this.gateInterazionali = gateInterazionali;
        this.gateInterazionaliLiberi = gateInterazionali;

        this.gateNazionali = gateNazionali;
        this.lock = new ReentrantLock();
        this.attendiInternazionale = lock.newCondition();
        this.attendiNazionale = lock.newCondition();
    }

    //ctrl + - (meno) = apri/chiudi metodo
    public void occupaGateInternazionale(Volo v) throws InterruptedException {
        lock.lock();

        //CTRL+ALT+T
        try {
            while (gateInterazionaliLiberi == 0) attendiInternazionale.await();

            gateInterazionaliLiberi--;
            System.out.println("[GATE-INTERNAZIONALE]: " + v.getName() + " occupa una gate. " +
                    "(int.liberi): " + gateInterazionaliLiberi + ")");
        } finally {
            lock.unlock();
        }

    }

    public void rilasciaGateInternazionale(Volo v) {
        lock.lock();

        try {
            gateInterazionaliLiberi++;
            //TODO: scrivere sout che visualizza chi sta rilasciando e quanti gate liberi ho
            attendiInternazionale.signal();
        } finally {
            lock.unlock();
        }
    }

    public void occupaGateNazionale(Volo volo) {

    }

    public void rilasciaGateNazionale(Volo volo) {

    }
}
