package PrimiEserciziNoSynch.Corridori;

public class Main {
    public static void main(String[] args) {
        Runner usain = new Runner("Usain Bolt");
        Runner justin = new Runner("Justin Gatlin");
        Runner marcel = new Runner("Marcel Jacobs");

        usain.start();
        justin.start();
        marcel.start();

        // E' verosimile abbastanza? Possibili migliorie? ;)
    }
}
