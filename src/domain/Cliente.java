package domain;

public class Cliente {

    private String nome;
    private String cpf;
    private String senha;
    private Conta conta;

    public Cliente(String nome, String cpf, String senha, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "Cliente\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Conta: " + (conta != null ? conta.getNumero() : "Não vinculada");
    }


}
