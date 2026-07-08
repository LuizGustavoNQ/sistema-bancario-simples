package service;

import model.Cliente;
import model.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoService {

    private Scanner scanner = new Scanner(System.in);

    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public void criarCliente() {

        System.out.println("------------------");

        System.out.print("\nNome: ");
        String nome = scanner.nextLine();

        System.out.print("\nCPF: ");
        String cpf = scanner.nextLine();

        System.out.print("\nTelefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone);
        clientes.add(cliente);

        System.out.println("\nCliente criado com sucesso!");
    }


    // Função para buscar o cliente pelo CPF para registrar o cadastro da conta.
    private Cliente buscarClientePorCpf(String cpf) {

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) { // Verifica se o CPF bate
                return cliente;
            }
        }

        return null;
    }

    public void criarConta() {

        System.out.println("------------------");

        Cliente clienteEncontrado = null;

        while (clienteEncontrado == null) {

            System.out.print("\nDigite o CPF do titular da conta: ");
            String cpfBuscar = scanner.nextLine();

            clienteEncontrado = buscarClientePorCpf(cpfBuscar);

            if (clienteEncontrado == null) {
                System.out.println("Erro: Cliente com o CPF informado não está cadastrado!");
            }
        }

        System.out.print("\nNúmero: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nAgência: ");
        String agencia = scanner.nextLine();

        System.out.print("\nSaldo: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();


        Conta conta = new Conta(numero, agencia, saldo, clienteEncontrado);

        contas.add(conta);

        System.out.println("\nConta criada com sucesso!");
    }

    public void listarClientes() {
        clientes.forEach(System.out::println);
    }

    public void listarContas() {
        contas.forEach(System.out::println);
    }

    public void exibirSaldoDaConta() {
        System.out.print("\nDigite o número da conta para consultar o saldo: ");
        int numeroBuscar = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Procura a conta na sua lista de contas
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroBuscar) {
                conta.consultarSaldo();
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    public void sacar() {
        System.out.println("\nDigite o número da conta para sacar o saldo: ");
        int numeroBuscar = scanner.nextInt();

        scanner.nextLine();

        for (Conta conta : contas) {
            if (conta.getNumero() == numeroBuscar) {
                conta.setSaldo(conta.sacar());
                return;
            }
        }

        System.out.println("Conta não encontrada!");
    }

    public void depositar() {
        System.out.println("\nDigite o número da conta para depositar: ");
        int numeroBuscar = scanner.nextInt();

        scanner.nextLine();

        for (Conta conta : contas) {
            if (conta.getNumero() == numeroBuscar) {
                conta.setSaldo(conta.depositar());
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }
}