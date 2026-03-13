package Exercises.Pirates.Es1;

import java.util.ArrayList;

public class Stiva {
    private ArrayList<Item> stiva;
    private final int MAX_SIZE;

    public Stiva(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.stiva = new ArrayList<>();
    }

    public synchronized void deposit(Item item) throws InterruptedException {
        while (stiva.size() == MAX_SIZE) {
            //CTRL+D: duplica riga
            System.out.println(Thread.currentThread().getName() + ": in attesa");
            wait();
        }
        stiva.add(item);
        System.out.println(Thread.currentThread().getName() + ": ha aggiunto " + item);
        notifyAll();
    }

    public synchronized Item getItem() throws InterruptedException {
        while (stiva.isEmpty()) wait();
        Item i = stiva.getFirst();
        notifyAll();
        return i;
    }
}
