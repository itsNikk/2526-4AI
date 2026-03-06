package ProdConsv1;

public class Buffer {
    //iL VERO VALORE SALVATO
    private int valore;

    //QUANTI NE HO ORA...
    private int numItems = 0;

    private final int BUFFERSIZE = 1;

    //Chiamato da CONSUMER
    public synchronized int getItem() throws InterruptedException {

        if (numItems == 0) wait();

        this.numItems--;
        System.out.print("C:" + valore);
        notify();
        return this.valore;
    }

    //Chiamato da PRODUCER
    public synchronized void setItem(int newVal) throws InterruptedException {

        if (numItems == BUFFERSIZE) wait();

        this.valore = newVal;
        this.numItems++;
        System.out.print("P:" + valore);
        notify();
    }

}
