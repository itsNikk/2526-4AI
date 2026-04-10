package Exercises.ElaborationChain_v1;

public class ElaborationChannel {
    private int storedValue;
    private boolean isFull;

    public ElaborationChannel() {
        this.storedValue = 0;
        this.isFull = false;
    }

    public synchronized void deposit(int value) throws InterruptedException {
        while (isFull) wait();

        this.storedValue = value;
        this.isFull = true;

        notifyAll();
    }


    public synchronized int retrieve() throws InterruptedException {
        while (!isFull) wait();

        this.isFull = false;
        notifyAll();

        return storedValue;
    }
}
