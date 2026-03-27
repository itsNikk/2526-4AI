package Exercises.SynchBarrier;

public class SynchBarrier {
    private final int numThreads;
    private int waitingThreads;

    public SynchBarrier(int numThreads) {
        waitingThreads = 0;
        this.numThreads = numThreads;
    }

    public synchronized void reachBarrier() throws InterruptedException {
        waitingThreads++;
        if (waitingThreads < numThreads) {
            System.out.println(Thread.currentThread().getName() + " ha raggiunto la barriera.");
            wait();
        } else {
            System.out.println("Soglia della barriera raggiunta. I thread ripartono e la barriera si resetta.");
            notifyAll();
            waitingThreads = 0;
        }
    }
}
