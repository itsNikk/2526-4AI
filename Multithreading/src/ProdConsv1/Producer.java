package ProdConsv1;

public class Producer extends Thread {

    private final Buffer buffer;

    public Producer(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        // Per 10 volte, fai +1 sul buffer
        for (int i = 1; i <= 10; i++) {
            try {
                buffer.setItem(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("P:" + i);s
        }
    }
}
