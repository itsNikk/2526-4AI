package Exercises.Bank;

public class Sportello {
    private final int cassieri;
    private int cassieriLiberi;

    public Sportello(int cassieri) {
        this.cassieri = cassieri;
        this.cassieriLiberi = cassieri;
    }

    public synchronized boolean occupy(Thread t) throws InterruptedException {
        long expiryTime = System.currentTimeMillis() + 5000;
        while (cassieriLiberi == 0) {
            long remainingTime = expiryTime - System.currentTimeMillis();
            if (remainingTime <= 0) return false;
            wait(remainingTime);
        }

        cassieriLiberi--;
        System.out.println("[SPORTELLO] " + t.getName() + " al cassiere"
                + " (liberi: " + cassieriLiberi + "/" + cassieri + ")");

        return true;
    }

    public synchronized void release(Thread t) {
        cassieriLiberi++;
        System.out.println("[SPORTELLO] " + t.getName() + " lascia il cassiere"
                + " (liberi: " + cassieriLiberi + "/" + cassieri + ")");
        notifyAll();
    }
}
