package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    public enum Tipo {SAQUE, DEPOSITO, TRANSFERENCIA};

    private Tipo tipo;
    private double valor;
    private Conta contaOrigem;
    private Conta contaDestino;
    private LocalDateTime dataHora;

    public Transacao() {
    }

    public Transacao(Tipo tipo, double valor, Conta contaOrigem, Conta contaDestino) {
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataHora = LocalDateTime.now();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataHora.format(fmt);

        switch (tipo){
            case SAQUE:
                return String.format("[%s] Saque: -%.2f", dataFormatada, valor);
            case DEPOSITO:
                return String.format("[%s] Depósito: +%.2f", dataFormatada, valor);
            case TRANSFERENCIA:
                return String.format("[%s] Transferência: -%.2f de %s para %s",
                    dataFormatada,
                    valor,
                    contaOrigem.getNumero(),
                    contaDestino.getNumero());
            default:
                return "Transação desconhecida";
        }

    }
}
