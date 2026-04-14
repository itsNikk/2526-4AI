package Exercises.Launchpad6;

public class Main {
    public static void main(String[] args) {
        final int NUM_RAMPE = 3;
        final int NUM_TORRI = 2;
        final int NUM_MISSIONI = 10;

        LaunchCenter launchCenter = new LaunchCenter(NUM_RAMPE, NUM_TORRI);

        for (int i = 0; i < NUM_MISSIONI; i++) new MissionEntity(i + 1, launchCenter).start();
    }
}
