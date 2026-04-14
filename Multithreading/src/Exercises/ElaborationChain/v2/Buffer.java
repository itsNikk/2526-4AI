package Exercises.ElaborationChain.v2;

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

    private void setFull(boolean full) {
        this.full = full;
    }

    private int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
