package PrimiEserciziNoSynch.HackerVsFirewall;

public class Firewall extends Thread {

    private Hacker hacker;

    public Firewall(String name, Hacker hacker) {
        super(name);

        this.hacker = hacker;
    }

    @Override
    public void run() {
        while (true) {
            if (hacker.getAttempts() >= 10) {
                System.out.println("Accesso concesso!");
                break;
            }
            if (hacker.getAttempts() % 3 == 0 && hacker.getAttempts() > 0) {
                System.out.println("Intruso bloccato!");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
