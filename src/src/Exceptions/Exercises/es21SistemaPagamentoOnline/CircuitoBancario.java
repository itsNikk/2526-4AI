package es21SistemaPagamentoOnline;

import es21SistemaPagamentoOnline.CustomExceptions.ConnessioneBancariaException;
import es21SistemaPagamentoOnline.CustomExceptions.FrodeRilevataException;

import java.util.Random;

public class CircuitoBancario {

    private Random randomGen;

    public CircuitoBancario() {
        this.randomGen = new Random();
    }

    public boolean autorizzaPagamento(CartaDiCredito cartaDiCredito, double importo) throws ConnessioneBancariaException {
        //Equivalente a (int) (Math.random() * 100)
        int prob = randomGen.nextInt(1, 100);

        //Può essere scritto anche con if() else if ma avrei un punto di ritorno scoperto...
        if (prob < 10) {
            throw new ConnessioneBancariaException("Timeout di rete avvenuto");
        }

        if (prob < 15) {
            throw new FrodeRilevataException("Rilevata frode bancaria");
        }

        cartaDiCredito.setSaldo(cartaDiCredito.getSaldo() - importo);
        return true;
    }

}
