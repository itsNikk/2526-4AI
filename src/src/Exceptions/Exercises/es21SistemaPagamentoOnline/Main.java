package es21SistemaPagamentoOnline;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== SISTEMA DI PAGAMENTO E-COMMERCE ===");

        // Creazione carte di test
        CartaDiCredito cartaScaduta = new CartaDiCredito("4532123456789012", 2023, 11, "123", 500.00);

        CartaDiCredito cartaSaldoBasso = new CartaDiCredito("5425233430109903", 2027, 8, "456", 15.00);

        CartaDiCredito cartaValida = new CartaDiCredito("4716258050958645", 2028, 12, "789", 1000.00);

        ProcessorePagamenti processore = new ProcessorePagamenti();

        // Scenario di test
        System.out.println("Tentativo 1: Pagamento con carta scaduta" + cartaScaduta.getNumero());
        processore.effettuaPagamento(cartaScaduta, 50.00);

        System.out.println("Tentativo 2: Pagamento che supera il saldo " + cartaSaldoBasso.getNumero());
        processore.effettuaPagamento(cartaSaldoBasso, 100.00);

        System.out.println("Tentativo 3-7: Pagamenti con carta valida (random esiti)");
        for (int i = 0; i < 15; i++) {
            boolean esito = processore.effettuaPagamento(cartaValida, 50.00);

            //Non bellissimo da leggere ma ok. Come potremmo fare altrimenti?
            if (esito) {
                System.out.println("Tentativo " + (i + 1) + ": Successo");
            } else System.out.println("Tentativo " + (i + 1) + ": Fallito");

            // Solo per leggibilità
            Thread.sleep(500);
        }

        processore.printTransactionLog();

        System.out.println("Saldo finale carta valida: €" + cartaValida.getSaldo());
    }
}
