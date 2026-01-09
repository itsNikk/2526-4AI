package Exceptions.Intro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // data una stirnga in input, e un carattere...
        // create una funzione che mi dice c'è o no quel carattere
        Scanner s = new Scanner(System.in);

        System.out.print("Dammi una stringa, please:");
        String str = s.nextLine();
        System.out.print("Dammi un char, please:");
        String charToSearch = s.nextLine();

        int index;
        try {
            index = s.nextInt();
            char charRes = getChar(str, index);
            System.out.println("ecco il char: " + charRes);
        } catch (InputMismatchException inputMismatchException) {
            index = 0;
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(exc.getMessage());
        }

        //Funzione ricerca(str, char) => int
        int res = searchChar(str, charToSearch);
        System.out.println(res);

    }

    private static char getChar(String s, int index) {
        return s.charAt(index);
    }

    private static int searchChar(String str, String toSearch) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == toSearch.charAt(0)) {
                return i;
            }

        }
        return -1;

    }

}
