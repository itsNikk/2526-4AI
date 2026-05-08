package Exercises.timedWait.A1;

import java.util.Random;

public class Cliente extends Thread {

    private final Sportello sportello;
    private final Random random;
    private boolean isServed;

    public Cliente(String name, Sportello sportello) {
        super(name);
        this.sportello = sportello;
        this.random = new Random();
        this.isServed = false;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " in attesa di un cassiere...");
            boolean obtained = sportello.occupy(this);
            if (!obtained) {
                System.out.println(getName() + " rinuncia: Timeout scaduto.");
                return;
            }

            isServed = true;
            System.out.println(getName() + ": in servizio!");
            Thread.sleep(2000 + random.nextInt(2000));
            sportello.release(this);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isServed() {
        return isServed;
    }

    public void setServed(boolean served) {
        isServed = served;
    }
}
