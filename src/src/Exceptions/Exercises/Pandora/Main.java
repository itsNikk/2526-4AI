package Exceptions.Exercises.Pandora;

public class Main {
    public static void main(String[] args) {
        try {
            Coordinata c = new Coordinata(564564645, 156561);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
