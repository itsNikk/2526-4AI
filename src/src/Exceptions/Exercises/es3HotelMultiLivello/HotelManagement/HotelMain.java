package es3HotelMultiLivello.HotelManagement;

import java.util.ArrayList;

public class HotelMain {
    public static void main(String[] args) {
        // Setup
        DatabaseSimulato db = new DatabaseSimulato();
        GestorePrenotazioni gestore = new GestorePrenotazioni(db);
        InterfacciaHotel interfaccia = new InterfacciaHotel(gestore);

        // Create a caso, così testo tutti i casi che mi interessano (NON E' OPZIONALE)
        richiestaConRetry(interfaccia, db, "101", "Mario Rossi");
        richiestaConRetry(interfaccia, db, "102", "Laura Bianchi");
        richiestaConRetry(interfaccia, db, "101", "Giuseppe Verdi");  // Camera occupata
        richiestaConRetry(interfaccia, db, "103", "");                 // Who's this guy?!
        richiestaConRetry(interfaccia, db, "104", null);               // WHO'S THIS GUY!?
        richiestaConRetry(interfaccia, db, "205", "Anna Neri");
        richiestaConRetry(interfaccia, db, "206", "Carlo Gialli");
        richiestaConRetry(interfaccia, db, "102", "Francesca Viola");  // Camera occupata
        richiestaConRetry(interfaccia, db, "207", "Roberto Blu");
        richiestaConRetry(interfaccia, db, "208", "Silvia Arancio");

        // Stampa storico finale
        interfaccia.stampaStorico();
    }

    //NON era scritto, è solo un metodo di supporto (helper) per testare in maniera più realistica il sistema
    private static void richiestaConRetry(InterfacciaHotel interfaccia, DatabaseSimulato db,
                                          String camera, String cliente) {
        interfaccia.richiestaPrenotazione(camera, cliente);

        if (ultimoErroreDiSistema(interfaccia)) {
            System.out.println("Ripristino connessione DB e riprovo...");
            db.ripristinaConnessione();
            interfaccia.richiestaPrenotazione(camera, cliente);
        }
    }

    private static boolean ultimoErroreDiSistema(InterfacciaHotel interfaccia) {
        ArrayList<String> storico = interfaccia.getStoricoOperazioni();
        //Perchè 2?
        if (storico.size() < 2) return false;

        String penultimoMsg = storico.get(storico.size() - 2);
        return penultimoMsg.contains("Errore di sistema");
    }
}
