package es21SistemaPagamentoOnline;

public class CartaDiCredito {
    private String numero;
    private int scandezaAnno;
    private int scandezaMese;
    private String cvv;
    private double saldo;

    public CartaDiCredito(String numero, int scandezaAnno, int scandezaMese, String cvv, double saldo) {
        this.numero = numero;
        this.scandezaAnno = scandezaAnno;
        this.scandezaMese = scandezaMese;
        this.cvv = cvv;
        this.saldo = saldo;
    }

    public boolean isScaduta() {
        //Estremamente brutto ma non ricordo se avete visto Calendar (cfr. Gestione date in Java)
        // Problemi di design di questa valida soluzione?
        int meseCorrente = 1;
        int annoCorrente = 2026;

        return scandezaAnno < annoCorrente || (scandezaAnno == annoCorrente && scandezaMese < meseCorrente);
    }

    public boolean hasSaldo(double importo) {
        return saldo >= importo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getScandezaAnno() {
        return scandezaAnno;
    }

    public void setScandezaAnno(int scandezaAnno) {
        this.scandezaAnno = scandezaAnno;
    }

    public int getScandezaMese() {
        return scandezaMese;
    }

    public void setScandezaMese(int scandezaMese) {
        this.scandezaMese = scandezaMese;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
