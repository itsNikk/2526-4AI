package Exceptions.verifica27022026.TombRaider;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int torches = 10;
        int corridors = 15;
        Explorer explorer = new Explorer("Indiana", torches);

        Tomb tomb = new Tomb(explorer, corridors);
        try {
            tomb.explore();
        } catch (OutOfTorchesException out) {
            System.out.println(out.getMessage());
        }

    }
}
