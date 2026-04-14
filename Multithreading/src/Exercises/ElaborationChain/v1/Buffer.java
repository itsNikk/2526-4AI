package Exercises.ElaborationChain.v1;

public class Buffer {
    private int value;
    private boolean full;

    public Buffer() {
        this.full = false;
    }

    public synchronized void insertValue(int incomingValue) throws InterruptedException {
        while (isFull()) wait();

        setValue(incomingValue);
        setFull(true);

        notifyAll();
    }

    public synchronized int retrieveValue() throws InterruptedException {
        while (!isFull()) wait();

        setFull(false);
        notifyAll();

        return getValue();
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
