package Exercises.Launchpad6;

public class MissionEntity extends Thread {

    private final LaunchCenter launchCenter;

    public MissionEntity(int missionCode, LaunchCenter launchCenter) {
        super("Missione-" + missionCode);
        this.launchCenter = launchCenter;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " in preparazione...");
            Thread.sleep(getRandomNumberInRange(1000, 2000));
            launchCenter.acquisiciRisorse(this);

            int missionDuration = getRandomNumberInRange(2000, 3000);
            System.out.println(getName() + " in fase di lancio! Durata missione: " + (missionDuration / 1000) + "sec.");
            Thread.sleep(missionDuration);

            launchCenter.rilasciaRisorse(this);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotta");
            currentThread().interrupt();
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    @Override
    public String toString() {
        return getName();
    }
}
