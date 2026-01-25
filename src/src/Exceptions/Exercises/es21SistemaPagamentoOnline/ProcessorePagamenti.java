package es21SistemaPagamentoOnline;

import es21SistemaPagamentoOnline.CustomExceptions.ConnessioneBancariaException;
import es21SistemaPagamentoOnline.CustomExceptions.FrodeRilevataException;

import java.lang.classfile.attribute.CodeAttribute;
import java.util.ArrayList;

public class ProcessorePagamenti {
    private ArrayList<String> logTransazioni;

    public ProcessorePagamenti() {
        this.logTransazioni = new ArrayList<>();
    }

    public boolean effettuaPagamento(CartaDiCredito cartaDiCredito, double importo) {
        String msg = "";

        //FASE 1: Validazione preventiva.
        //Si poteva fare anche con if()else if()? perchè/perchè no?
        if (cartaDiCredito.isScaduta()) {
            msg = "RIFIUTATO - Carta " + cartaDiCredito.getNumero() + " scaduta";
            logTransazioni.add(msg);
            return false;
        }

        if (!cartaDiCredito.hasSaldo(importo)) {
            msg = "RIFIUTATO - Saldo insufficiente su carta " + cartaDiCredito.getNumero()
                    + " (disponibile: " + cartaDiCredito.getSaldo() + ", richiesto: " + importo + ")";

            logTransazioni.add(msg);
            return false;
        }

        //Estrema semplificazione della realtà...
        CircuitoBancario circuitoBancario = new CircuitoBancario();

        try {
            circuitoBancario.autorizzaPagamento(cartaDiCredito, importo);
            //Ovviamente posso scrivere tutto su una riga, per leggibilità ho usato +=
            msg = "SUCCESSO - Pagamento autorizzato: " + importo + " su carta " + cartaDiCredito.getNumero();
            msg += "(saldo residuo: " + cartaDiCredito.getSaldo() + ")";
            logTransazioni.add(msg);
            return true;
        } catch (ConnessioneBancariaException e) {
            //Gestione locale dell'eccezione CHECKED. No rilancio.
            msg = "ERRORE -  Connessione bancaria fallita per " + importo +
                    " - Riprovare più tardi (" + e.getMessage() + ")";
            logTransazioni.add(msg);
            return false;
        } catch (FrodeRilevataException e) {
            msg = "BLOCCO - FRODE RILEVATA su carta " + cartaDiCredito.getNumero() + " - carta bloccata (" + e.getMessage() + ")";
            logTransazioni.add(msg);
            return false;
        }
    }

    public void printTransactionLog() {
        //NON è specificato il formato, quindi la funzionalità deve esserci ma la implemento nel modo più facile possibile.
        System.out.println("=== LOG TRANSAZIONI ===");
        for (String transazione : logTransazioni) System.out.println(transazione);
        //Risultato similissimo, semplicemente mostro anche un indice.
        //for (int i = 0; i < logTransazioni.size(); i++) System.out.println((i + 1) + ". " + logTransazioni.get(i));
    }
}
