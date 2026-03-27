package PrimiEserciziNoSynch.SurpriseTimerV2;

public class Bomb extends Thread {

    private final int time;

    public Bomb(String name) {
        super(name);
        this.time = (int) (Math.random() * 10) + 1;
    }

    public Bomb(String name, int time) {
        this.time = time;
        //equivalente a super(name)
        setName(name);
    }

    @Override
    public void run() {
        //countdown da X a 0... poi BOOM!
        for (int i = time; i > 0; i--) {
            System.out.println(getName() + " Bomb countdwon: " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
                return;
            }
        }
        System.out.println(getName() + "> BOOM!");
        System.exit(0);
    }
}
