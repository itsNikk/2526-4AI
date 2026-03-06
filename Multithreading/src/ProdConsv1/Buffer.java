package ProdConsv1;

public class Buffer {
    //iL VERO VALORE SALVATO
    private int valore;

    //QUANTI NE HO ORA...
    private int numItems = 0;

    final int BUFFERSIZE = 3;

    //CONSUMER
    public synchronized int getItem() throws InterruptedException {

        if (numItems == 0) wait();

        this.numItems--;

        return this.valore;
    }

    //PRODUCER
    public synchronized void setItem(int newVal) throws InterruptedException {

        if (numItems == BUFFERSIZE) wait();

        this.valore = newVal;
        this.numItems++;
    }

}
