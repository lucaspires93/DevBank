package service;

import domain.Conta;

public class ContaService {

    public ContaService() {
    }

    public void depositar(Conta conta, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }

        conta.setSaldo(conta.getSaldo() + valor);
        System.out.printf("Depósito de R$%.2f", valor, "realizado com sucesso.");
    }

    public void sacar(Conta conta, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }
        if (conta.getSaldo() < valor) {
            System.out.println("Saldo insuficiente.");
            return;
        }
        conta.setSaldo(conta.getSaldo() - valor);
        System.out.printf("Saque de R$%.2f", valor, " realizado com sucesso.");
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }
        if (origem.getSaldo() < valor) {
            System.out.println("Saldo insuficiente.");
            return;
        }
        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);

        System.out.printf("Transferência de R$%.2f ", valor, " realizada para a conta de "
                + destino.getCliente() + " com sucesso.");
    }
}
