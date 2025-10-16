package domain;

public class Conta {

    protected int numero;
    public double saldo;
    protected Cliente cliente;

    public Conta() {
        this.saldo = 0.0;
        this.cliente = null;
    }

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0.0;
        this.cliente = null;
    }

    public Conta(int numero, double saldo, Cliente cliente) {
        super();
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        String nomeCliente = (cliente != null) ? cliente.getNome() : "Não vinculado";
        return "Conta\n" +
                "Número: " + numero + "\n" +
                "Cliente: " + cliente + "\n" +
                "Saldo: R$" + String.format("%.2f", saldo);
    }

}
