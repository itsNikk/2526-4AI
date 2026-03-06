package ProdConsv1;

public class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        int v;
        for (int i = 1; i <= 10; i++) {
            //Non CANCELLA
            try {
                v = buffer.getItem();
                System.out.print("C:" + v);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
