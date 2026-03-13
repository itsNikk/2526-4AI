package Exercises.Pirates.Es1;

public class Es1Main {
    public static void main(String[] args) {
        Stiva stiva = new Stiva(5);
        final int N = 30;
        final int nPirati = 3;
        final int nScrivani = 2;

        //Pirati
        Thread[] pirati = new Thread[nPirati];
        Thread[] scrivani = new Thread[nScrivani];

        for (int i = 0; i < nPirati; i++) {
            pirati[i] = new Thread(() -> {
                //Sono nel run di un thread
                for (int count = 0; count < N / nPirati; count++) {
                    try {
                        stiva.deposit(new Item("Item " + count));
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                }
            }, "Pirata " + (i + 1));
        }

        //Scrivani
        for (int i = 0; i < nScrivani; i++) {
            scrivani[i] = new Thread(() -> {
                for (int j = 0; j < N / nScrivani; j++) {
                    try {
                        Item item = stiva.getItem();
                        System.out.println(Thread.currentThread().getName() + " annota " + item + " nel registro della nave");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "Scrivano " + (i + 1));
        }


        for (Thread t : pirati) t.start();
        //for (Thread scrivano : scrivani) scrivano.start();
        try {
            for (Thread t : pirati) t.join();
            for (Thread scrivano : scrivani) scrivano.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }
}
