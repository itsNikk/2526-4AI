package Exercises.ElaborationChain.v1;

// Lo potremmo chiamare consumatore...
public class Collector extends Thread {

    //Da dove prendo i valori
    private final Buffer in;
    private final int interazioni;

    public Collector(Buffer in, int interazioni) {
        super("Collettore");
        this.in = in;
        this.interazioni = interazioni;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= interazioni; i++) {
                int valore = in.retrieveValue();
                System.out.println("[Risultato #" + i + "]: " + valore);
            }
        } catch (InterruptedException _) {
            currentThread().interrupt();
        }
    }
}
