package Exceptions.Exercises.CF;

import Exceptions.Exercises.CF.cfExceptions.CodiceFiscaleNonValidoException;

public class CodiceFiscale {
    private final int MAX_LENGTH = 16;

    //Implementate questo esercizio sennza usare isLetterOrDigit oppure is Uppercase
    public CodiceFiscale(String cf) throws CodiceFiscaleNonValidoException {
        if (cf.length() != MAX_LENGTH) throw new CodiceFiscaleNonValidoException("CF troppo lungo");

        for (int i = 0; i < cf.length(); i++) {
            if (!Character.isLetterOrDigit(cf.charAt(i)))
                throw new CodiceFiscaleNonValidoException("cf non alfanumerico");
        }

        if (!OnlyCFStaticMethods.isCharUpperCase(cf.charAt(cf.length() - 1))) {
            throw new CodiceFiscaleNonValidoException("CTRL CHAR non valido");
        }

        /*
         * 1) SPLIT + FOR
         * 2) charAt + for
         * 3) for/foreach + ASCII
         * 4) due cicli + alfabeto (occhioa due for, è sempre 16)
         */
    }


}
