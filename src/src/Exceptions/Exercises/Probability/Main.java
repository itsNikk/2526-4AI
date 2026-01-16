package Exceptions.Exercises.Probability;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        final double THRESHOLD = 0.1;
        for (int i = 0; i < 100000; i++) {
            double val = r.nextDouble(); //[0.0, 1.0])

            System.out.println(i + " : " + val);
            if (val <= THRESHOLD) {
                throw new RuntimeException("BOOM");
            }


            //Sys call -PCB
            Thread.sleep(1000);
        }
    }
}
