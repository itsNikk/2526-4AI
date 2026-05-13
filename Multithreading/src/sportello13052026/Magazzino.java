package sportello13052026;

import java.util.ArrayList;
import java.util.List;

public class Magazzino {
    private final int MAX_CAPACITY;
    private ArrayList<Materiale> buffer;


    public Magazzino(int capacity) {
        this.MAX_CAPACITY = capacity;
        this.buffer = new ArrayList<>();
    }

    //chiamato solo dai Prod...
    public synchronized void deposita(Materiale materiale) throws InterruptedException {
        //fintanto che so' pien'....
        while (buffer.size() == MAX_CAPACITY) wait();

        buffer.add(materiale);
        System.out.println("Aggiunto nuovo materiale: (" + buffer.size() + " / " + MAX_CAPACITY + ")");
        notifyAll();
    }

    public synchronized Materiale preleva() throws InterruptedException {

        while (buffer.isEmpty()) wait();

        Materiale m = buffer.get(0);
        buffer.remove(m);
        notifyAll();
        System.out.println("rimosso materiale: (" + buffer.size() + " / " + MAX_CAPACITY + ")");
        return m;
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }
}
