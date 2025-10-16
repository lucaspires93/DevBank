package service;

import domain.Cliente;
import domain.Conta;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteService() {
    }

    private boolean validarCpf(String cpf) {
        return clientes.stream().noneMatch(c -> c.getCpf() == cpf);
    }

    public boolean validarSenha(String senha) {
        return clientes.stream().noneMatch(c -> c.getSenha() == senha);
    }

    public boolean cadastrarCliente(String cpf, String nome, String senha, Conta conta) {
        if (!validarCpf(cpf)) {
            System.out.println("CPF inválido ou já cadastrado.");
            return false;
        }
        if (!validarSenha(senha)) {
            System.out.println("Senha incorreta.");
            return false;
        }
        if (senha == null || senha.length() < 4) {
            System.out.println("Senha inválida. Deve ter pelo menos 4 caracteres.");
            return false;
        }
        Cliente cliente = new Cliente(nome, cpf, senha, conta);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
        return true;
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
}
