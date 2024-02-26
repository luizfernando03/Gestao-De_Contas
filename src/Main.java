import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ========== Bem vindo ao Banco ==========");
        System.out.println("Digite seu nome: ");
        String nome  = scanner.nextLine();
        System.out.println("Digite seu CPF ou CNPJ:");
        String documento = scanner.nextLine();
        System.out.println("Digite '1' para Pessoa Fisica ou '2' para Pessoa Fisica: ");
        int tipo = scanner.nextInt();
        TipoCliente tipoCliente = tipo == 1 ? TipoCliente.PESSOA_FISICA : TipoCliente.PESSOA_JURIDICA;
        Cliente cliente = new Cliente(nome, documento, tipoCliente);

        while (true) {
            System.out.println("===== Menu Interativo =====");
            System.out.println(" 1 Abrir Conta! ");
            System.out.println(" 2 Realizar Operção ");
            System.out.println(" 3 Sair ");
            System.out.println("Escolha uma opção");
            int opcao = scanner.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("======== Abrir Conta ========");
                    System.out.println("Digite o tipo de Conta (1 - Corrente, 2- Poupança, 3 - Investimento): ");
                    int tipoConta = scanner.nextInt();
                    System.out.println("Digite Saldo inicial: ");
                    BigDecimal saldoInicial = scanner.nextBigDecimal();
                    cliente.abrirConta(saldoInicial, TipoConta.values()[tipoConta - 1]);
                    break;
                case 2:
                    System.out.println(" ======= Realizar Operação =======");
                    System.out.println(" 1 Depósito");
                    System.out.println(" 2 Saque ");
                    System.out.println(" 3 Transferência ");
                    System.out.println(" 4 Exibir Extrato ");
                    System.out.println(" 5 Aplicar Rendimento ");
                    System.out.println(" 6 Sair ");
                    System.out.println(" Qual Operação Deseja Fazer Hoje: ");
                    String operacao = scanner.next();
                    cliente.realizarOperacao(operacao, scanner);
                    break;
                case 3:
                    System.out.println("Encerrando o sistema. Obrigado por ultilizar nossos Serviços");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor escolha uma opção válida.");
            }
        }

    }
}