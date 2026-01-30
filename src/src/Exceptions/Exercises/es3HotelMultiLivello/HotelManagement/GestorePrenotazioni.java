package es3HotelMultiLivello.HotelManagement;

import es3HotelMultiLivello.HotelExceptions.CameraOccupataException;
import es3HotelMultiLivello.HotelExceptions.ClienteNonValidoException;
import es3HotelMultiLivello.HotelExceptions.DatabaseException;
import es3HotelMultiLivello.HotelExceptions.PrenotazioneException;

public class GestorePrenotazioni {
    private DatabaseSimulato db;

    public GestorePrenotazioni() {
        this.db = new DatabaseSimulato();
    }

    public GestorePrenotazioni(DatabaseSimulato db) {
        this.db = db;
    }

    public void prenota(String numeroCamera, String nomeCliente) throws PrenotazioneException {
        if (nomeCliente == null || nomeCliente.isEmpty())
            throw new ClienteNonValidoException("Bisogna fornire nome cliente");

        try {
            if (!db.verificaDisponibilita(numeroCamera))
                throw new CameraOccupataException("La camera " + numeroCamera + " non è disponibile");
        } catch (DatabaseException e) {
            throw new PrenotazioneException("Errore sistema: " + e.getMessage());
        }

        try {
            db.salvaPrenotazione(numeroCamera, nomeCliente);
            System.out.println("Prenotazione confermata. Camera n°" + numeroCamera + " per cliente " + nomeCliente);
        } catch (DatabaseException databaseException) {
            throw new PrenotazioneException("Errore sistema: " + databaseException.getMessage());
        }
    }
}
