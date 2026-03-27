package Exercises.SynchBarrier;

public class BarrierThread extends Thread {

    private final SynchBarrier barrier;

    public BarrierThread(String name, SynchBarrier barrier) {
        super(name);
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            int workTime = (int) (Math.random() * 5000) + 2000;
            System.out.println(getName() + " lavora per " + workTime + " seconds.");
            sleep(workTime);
            barrier.reachBarrier();
            System.out.println(getName() + " riprende a lavorare...");
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
            return;
        }

    }
}
