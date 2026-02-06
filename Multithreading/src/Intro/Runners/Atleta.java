package Intro.Runners;

public class Atleta extends Thread {

    private String name;
    private long startTime;
    private long endTime;

    @Override
    public void run() {
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            System.out.println(name + ": Step " + (i + 1));
        }

        endTime = System.currentTimeMillis();
    }

    public long getRaceTime() {
        return endTime - startTime;
    }
}
