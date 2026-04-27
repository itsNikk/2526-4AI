package Exercises.Bank;

public class BankMain {
    private static final int NUM_CLIENTI = 16;
    private static final int NUM_CASSIERI = 2;

    public static void main(String[] args) {
        Sportello sportello = new Sportello(NUM_CASSIERI);

        Cliente[] clienti = new Cliente[NUM_CLIENTI];
        for (int i = 0; i < NUM_CLIENTI; i++) clienti[i] = new Cliente("Cliente-" + (i + 1), sportello);

        for (Cliente c : clienti) c.start();
        for (Cliente c : clienti) {
            try {
                c.join();
            } catch (InterruptedException e) {
                System.out.println("Main interrotto");
                return;
            }
        }

        int serviti = 0;
        int rinunciati = 0;
        for (Cliente c : clienti) {
            if (c.isServito()) serviti++;
            else rinunciati++;
        }

        System.out.println("Serviti: " + serviti + " | Rinunciatari: " + rinunciati);
        System.out.println("Simulazione terminata.");
    }
}
