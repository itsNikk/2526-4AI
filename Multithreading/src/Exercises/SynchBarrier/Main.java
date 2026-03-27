package Exercises.SynchBarrier;

public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        SynchBarrier barrier = new SynchBarrier(NUM_THREADS);
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) threads[i] = new BarrierThread("BT" + (i + 1), barrier);

        for (Thread thread : threads) thread.start();
    }
}
