package PrimiEserciziNoSynch.HackerVsFirewall;

public class Hacker extends Thread {

    private int attempts;

    public Hacker(String name) {
        super(name);
        attempts = 0;
    }

    @Override
    public void run() {
        while (attempts < 10) {
            attempts++;

            System.out.println("Tentativo di accesso " + attempts);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
            }
        }
    }


    public int getAttempts() {
        return attempts;
    }
}
