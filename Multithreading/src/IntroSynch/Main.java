package IntroSynch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AdderThread adderThread = new AdderThread();
        AdderThread adderThread2 = new AdderThread();

        adderThread2.start();
        adderThread.start();
        adderThread.join();
        adderThread2.join();

        System.out.println("Counter:" + AdderThread.counter.getCounter());
    }
}
