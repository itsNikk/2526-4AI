package PrimiEserciziNoSynch.SurpriseTimer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Thread bomb = new Thread(new Bomb());
        bomb.setName("Bomba");
        bomb.start();

        sc.nextLine();
        //Interrompo (unironically) un thread :)
        bomb.interrupt();

    }
}
