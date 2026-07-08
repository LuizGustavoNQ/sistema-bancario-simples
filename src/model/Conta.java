package model;

import java.util.Scanner;

public class Conta {
    private int numero;
    private String agencia;
    private double saldo;
    private Cliente cliente;

    Scanner scanner = new Scanner(System.in);

    public Conta(int numero, String agencia, double saldo, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double depositar() {
        System.out.println("Valor para depositar: ");
        double valorDeposito = scanner.nextDouble();
        return saldo + valorDeposito;
    }

    public double sacar() {
        System.out.println("Valor para sacar: ");
        double valorSaque = scanner.nextDouble();

        if (valorSaque > saldo) {
            System.out.println("Valor maior que o saldo total da conta!");
            return saldo;
        }
        return saldo - valorSaque;
    }

    public void transferir() {

    }

    public void consultarSaldo() {
        System.out.println(saldo);
    }

    @Override
    public String toString() {
        return "Conta {" +
                "Número: " + numero +
                ", Agência: '" + agencia + '\'' +
                ", Saldo: R$ " + String.format("%.2f", saldo) +
                ", Titular: " + (cliente != null ? cliente.getNome() : "Sem titular") +
                '}';
    }
}
