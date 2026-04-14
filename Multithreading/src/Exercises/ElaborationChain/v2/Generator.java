package Exercises.ElaborationChain.v2;

// Lo potremmo chiamare produttore...
public class Generator extends Thread {

    //Dove inseriro i valori
    private final Buffer out;
    private final int iterazioni;

    public Generator(Buffer out, int iterazioni) {
        super("Generatore");
        this.out = out;
        this.iterazioni = iterazioni;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < iterazioni; i++) {
                int value = (int) (Math.random() * 100);
                System.out.println("[GENERATORE] produce: " + value);
                out.insertValue(value);
            }
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }
}
