package IntroSynch;

import java.util.concurrent.Semaphore;

public class AdderThread extends Thread {

    static Counter counter = new Counter();
    static final Semaphore sem = new Semaphore(1);

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                sem.acquire();
                System.out.print(getName() + ":" + (i + 1) + "\r");
                counter.add(1);
                sem.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                sem.release();
                break;
            }
        }
    }
}
