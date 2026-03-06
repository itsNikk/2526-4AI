package ProdConsv1;

public class Buffer {
    //iL VERO VALORE SALVATO
    private int valore;
    private int numItems = 0;

    final int BUFFERSIZE = 1;

    //CONSUMER
    public synchronized int getItem() {
    }

    //PRODUCER
    public synchronized void setItem(int newVal) {
    }

}
