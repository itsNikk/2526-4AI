package es3HotelMultiLivello.HotelManagement;

import es3HotelMultiLivello.HotelExceptions.DatabaseException;

import java.util.ArrayList;
import java.util.Random;

public class DatabaseSimulato {
    private ArrayList<String> camereOccupate;
    private boolean connessioneAttiva;

    private Random r;

    public DatabaseSimulato() {
        this.r = new Random();
        this.connessioneAttiva = true;
        this.camereOccupate = new ArrayList<>();
    }

    public boolean verificaDisponibilita(String numeroCamera) throws DatabaseException {
        if (!connessioneAttiva) throw new DatabaseException("Connessione al DB persa");

        int prob = r.nextInt(1, 100);
        if (prob < 5) {
            connessioneAttiva = false;
            throw new DatabaseException("Timeout query");
        } else {
            return !camereOccupate.contains(numeroCamera);
        }
    }

    public void salvaPrenotazione(String numeroCamera, String nomeCliente) throws DatabaseException {
        if (!connessioneAttiva) throw new DatabaseException("Connessione al DB persa.");
        int prob = r.nextInt(1, 100);
        if (prob < 3) throw new DatabaseException("Errore scrittura");
        else camereOccupate.add(numeroCamera);
    }

    public void ripristinaConnessione() {
        connessioneAttiva = true;
    }
}
