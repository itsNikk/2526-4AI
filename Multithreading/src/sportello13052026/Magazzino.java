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


    public synchronized void deposita(Materiale materiale) throws InterruptedException {
        //fintanto che so' pien'....
        while (buffer.size() == MAX_CAPACITY) wait();

        buffer.add(materiale);
        System.out.println("Aggiunto nuovo materiale: (" + buffer.size() + " / " + MAX_CAPACITY + ")");
        notifyAll();
    }

    public Materiale preleva(){
        
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }
}
