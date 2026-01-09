package Exceptions.Exercises.CF;

import Exceptions.Exercises.CF.cfExceptions.CodiceFiscaleNonValidoException;

public class Anagrafe {

    public void addCitizen(String cf) {
        try {
            CodiceFiscale cod = new CodiceFiscale(cf);
            System.out.println(cod + " valido");
        } catch (CodiceFiscaleNonValidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
