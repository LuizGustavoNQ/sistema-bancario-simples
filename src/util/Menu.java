package util;

import service.BancoService;
import java.util.Scanner;

public class Menu {

    BancoService bancoService = new BancoService();
    Scanner scanner = new Scanner(System.in);
    int opcao;

    public void imprimirMenu() {
        System.out.println("\n=================================");
        System.out.println("          SISTEMA BANCÁRIO        ");
        System.out.println("=================================");
        System.out.println("  [1] Criar Cliente");
        System.out.println("  [2] Criar Conta");
        System.out.println("  [3] Listar Clientes");
        System.out.println("  [4] Listar Contas");
        System.out.println("  [5] Consultar Saldo");
        System.out.println("  [6] Sacar");
        System.out.println("  [7] Depositar");
        System.out.println("  [8] Sair");
        System.out.println("=================================");
    }

    public void selecionaOpcao() {
        while (opcao != 8) {
            imprimirMenu();
            System.out.print("Digite a opção desejada: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\n[ERRO] Por favor, digite apenas números!");
                scanner.next();
                continue;
            }

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    bancoService.criarCliente();
                    break;
                case 2:
                    bancoService.criarConta();
                    break;
                case 3:
                    bancoService.listarClientes();
                    break;
                case 4:
                    bancoService.listarContas();
                    break;
                case 5:
                    bancoService.exibirSaldoDaConta();
                    break;
                case 6:
                    bancoService.sacar();
                    break;
                case 7:
                    bancoService.depositar();
                    break;
                case 8:
                    System.out.println("\n>>> Encerrando o sistema. Até logo! <<<");
                    break;
                default:
                    System.out.println("\n[ERRO] Opção Inválida! Tente novamente.");
                    break;
            }
        }
    }
}