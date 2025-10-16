package controller;

import domain.Cliente;
import domain.Conta;
import service.ClienteService;
import service.ContaService;

import java.util.Random;
import java.util.Scanner;

public class BankController {

    private final Scanner sc = new Scanner(System.in);
    private final ContaService contaService = new ContaService();
    private final ClienteService clienteService = new ClienteService();

    public void iniciarSistema() {

        int opcao;
//        =============MENU PINCIPAL===========
        do {
            System.out.println("\n--- MENU PRINCIPAL ---\n");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Menu do cliente");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> menuCliente();
                case 0 -> System.out.println("Encerrando programa");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);


        sc.close();
    }


    public void cadastrarCliente() {
        System.out.println("\n--- CADASTRAR CLIENTE ---\n");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Cpf: ");
        String cpf = sc.nextLine();
        System.out.print("Senha (mín. 4 caracteres): ");
        String senha = sc.nextLine();


        int numeroConta = gerarNumeroConta();
        Conta conta = new Conta(numeroConta);

        boolean cadastrado = clienteService.cadastrarCliente(cpf, nome, senha, conta);
        if (cadastrado) {
            System.out.printf("Conta número %d criada para %s.%n", numeroConta, nome);
        }


    }

    private void menuCliente() {
        System.out.print("\nDigite o CPF do cliente: ");
        String cpf = sc.nextLine();
        System.out.print("Digite a senha do cliente: ");
        String senha = sc.nextLine();

        Cliente cliente = clienteService.buscarCliente(cpf);

        if (cliente == null || !cliente.getSenha().equals(senha)) {
            System.out.println("CPF ou senha incorretos!");
            return; // volta ao menu principal
        }

        int opcao;
        do {
            System.out.println("\n--- MENU DO CLIENTE (" + cliente.getNome() + ") ---");
            System.out.println("1 - Depósito");
            System.out.println("2 - Saque");
            System.out.println("3 - Transferência");
            System.out.println("4 - Consultar saldo");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("\nDigite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do depósito: ");
                    Double valor = lerDouble();
                    if (valor != null) {
                        contaService.depositar(cliente.getConta(), valor);
                    }
                }
                case 2 -> {
                    System.out.print("Valor do saque: ");
                    Double valor = lerDouble();
                    if (valor != null) {
                        contaService.sacar(cliente.getConta(), valor);
                    }
                }
                case 3 -> {
                    System.out.print("CPF do cliente destino: ");
                    String cpfDestino = sc.nextLine();
                    Cliente destino = clienteService.buscarCliente(cpfDestino);
                    if (destino == null) {
                        System.out.println("Cliente destino não encontrado!");
                        break;
                    }
                    System.out.print("Valor da transferência: ");
                    Double valor = lerDouble();
                    if (valor != null) {
                        contaService.transferir(cliente.getConta(), destino.getConta(), valor);
                    }
                }
                case 4 -> {
                    System.out.printf("Saldo atual: R$%.2f%n", cliente.getConta().getSaldo());
                }
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private int gerarNumeroConta() {
        Random random = new Random();
        int numero;
        boolean existe;
        do {
            numero = random.nextInt(9000) + 1000; // gera número de 1000 a 9999
            int finalNumero = numero;
            existe = clienteService.listarClientes().stream()
                    .anyMatch(c -> c.getConta().getNumero() == finalNumero);
        } while (existe);
        return numero;
    }

    private Double lerDouble() {
        String entrada = sc.nextLine().replace(",", ".");
        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido!");
            return null;
        }
    }

}


