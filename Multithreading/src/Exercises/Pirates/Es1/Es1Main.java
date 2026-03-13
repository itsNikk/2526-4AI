package Exercises.Pirates.Es1;

public class Es1Main {
    public static void main(String[] args) {
        Stiva s = new Stiva(10);
        final int N = 30;
        final int nPirati = 3;
        final int nScrivani = 2;

        //Pirati
        Thread[] pirati = new Thread[nPirati];

        for (int i = 0; i < nPirati; i++) {
            pirati[i] = new Thread(() -> {
                //Sono nel run di un thread
                for (int count = 0; count < N / nPirati; count++) {
                    try {
                        s.deposit(new Item("Item " + count));
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }


        //Scrivani


        for (Thread t : pirati) t.start();
        try {
            for (Thread t : pirati) t.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }
}
