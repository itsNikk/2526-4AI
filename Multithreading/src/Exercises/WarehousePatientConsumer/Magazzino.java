package Exercises.WarehousePatientConsumer;

import java.util.ArrayList;

public class Magazzino {

    private final int capacita;
    private final ArrayList<Integer> pacchi;
    private final String warehouseIdentifier = "WHouse";

    public Magazzino(int capacita) {
        this.capacita = capacita;
        this.pacchi = new ArrayList<>();
    }

    public synchronized void deposita(int pacco, Thread t) throws InterruptedException {
        while (pacchi.size() >= capacita) wait();
        pacchi.add(pacco);
        System.out.println("[" + warehouseIdentifier + "] " + t.getName() + " deposita pacco " + pacco
                + " (occupazione: " + pacchi.size() + "/" + capacita + ")");
        notifyAll();
    }

    public synchronized Integer preleva() throws InterruptedException {
        wait(4000);
        if (pacchi.isEmpty()) return null; //Let's talk about this
        int pacco = pacchi.removeFirst(); //same as remove(0)
        System.out.println("[" + warehouseIdentifier + "] Corriere preleva pacco " + pacco
                + " (occupazione: " + pacchi.size() + "/" + capacita + ")");
        notifyAll();
        return pacco;
    }
}
