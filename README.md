# DevBankDigital - Mini Banco Digital em Java

DevBankDigital é um projeto de estudo que simula um **mini banco digital** utilizando Java puro, sem frameworks externos. Ele permite cadastrar clientes, criar contas, realizar depósitos, saques, transferências e consultar saldo, tudo via console.

---

## Tecnologias utilizadas
- Linguagem: **Java 17**
- IDE: IntelliJ IDEA
- Conceitos aplicados:
  - Programação Orientada a Objetos (POO)
  - Encapsulamento, herança e associação
  - Estruturas de dados básicas (List)
  - Validações de entrada do usuário
- Ferramentas:
  - Scanner para entrada de dados
  - Random para geração de números de conta únicos

---

## Funcionalidades
- Cadastro de clientes com CPF, nome, senha e criação de conta bancária
- Login de clientes por CPF e senha
- Depósito e saque com validação de valores
- Transferência entre contas de clientes com verificação de saldo
- Consulta de saldo da conta
- Geração automática de número de conta único (4 dígitos)
- Validações de CPF, senha e valores financeiros

---

## Estrutura do projeto
- **domain**: Classes que representam entidades do sistema (Cliente, Conta)  
- **service**: Lógica de negócio, operações bancárias e validações  
- **controller**: Interface de console, interação com o usuário  

---

## Aprendizados
Durante o desenvolvimento do DevBankDigital, aprimorei:
- Lógica de programação e organização de código em pacotes
- Criação de métodos seguros para operações financeiras
- Manipulação de entrada de dados do usuário com tratamento de erros
- Boas práticas de programação orientada a objetos e encapsulamento

---

## Como executar
1. Clone o repositório:
```bash
git clone <URL_DO_REPOSITORIO>
