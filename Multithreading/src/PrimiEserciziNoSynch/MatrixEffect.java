package PrimiEserciziNoSynch;

import java.util.Random;

class MatrixEffect extends Thread {
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println((char) (rand.nextInt(26) + 'A'));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}