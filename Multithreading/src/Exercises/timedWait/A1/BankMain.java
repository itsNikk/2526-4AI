package Exercises.timedWait.A1;

public class BankMain {
    private static final int NUM_CLIENTI = 8;
    private static final int NUM_CASSIERI = 2;

    //Nessuno interrompe il main, mi permetto di lancia exc nel main...
    public static void main(String[] args) throws InterruptedException {
        Sportello sportello = new Sportello(NUM_CASSIERI);

        Cliente[] clients = new Cliente[NUM_CLIENTI];
        for (int i = 0; i < clients.length; i++) clients[i] = new Cliente("Cliente-" + (i + 1), sportello);

        for (Cliente c : clients) c.start();
        for (Cliente c : clients) c.join();

        int givenUp = 0, served = 0;
        for (Cliente c : clients) {
            if (c.isServed()) served++;
            else givenUp++;
        }

        System.out.println("Serviti: " + served + " | Rinunciati: " + givenUp);
        System.out.println("Simulation ended. Bye :)");
    }
}
