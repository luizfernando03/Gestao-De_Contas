import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String documento;  // CPF ou CNPJ
    private TipoCliente tipo;  // Pessoa Fisica ou Pessoa Juridica.
    private List<Conta> contas;  // Lista de contas do Cliente

    public Cliente(String nome, String documento, TipoCliente tipo) {
        this.nome = nome;
        this.documento = documento;
        this.tipo = tipo;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    // Método para abrir  nova Conta
    public void abrirConta(BigDecimal saldoInicial, TipoConta tipoConta) {
        Conta novaConta = null;
        switch (tipoConta) {
            case CORRENTE:
                novaConta = new ContaCorrente(contas.size() + 1, saldoInicial, this);
                break;
            case POUPANCA:
                if (tipo == TipoCliente.PESSOA_JURIDICA) {
                    System.out.println("Cliente pessoa Juridica não pode abrir Conta Poupança ! ");
                    return;
                }
                novaConta = new ContaPoupanca(contas.size() + 1, saldoInicial, this);
                break;
            case INVESTIMENTO:
                novaConta = new ContaInvestimento(contas.size() + 1, saldoInicial, this, new ArrayList<>());
                break;
        }
        contas.add(novaConta);
    }

    // Método exibir extrato de uma conta especifica
    public void exibirExtrato(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                conta.exibirExtrato();
                return;
            }
        }
        System.out.println("Conta não encontrada ! ");
    }

    // Método para realizar operações bancarias (saque, depósito , etc)
    public void realizarOperacao(String operacao, Scanner scanner) {
        switch (operacao) {
            case "1":
                System.out.println("Digiet eo valor do depósito: "); // Código para dpósito
                BigDecimal valorDeposito = scanner.nextBigDecimal();
                break;
            case "2":
                System.out.println("Dite o valore do saque: "); // Código para saque
                BigDecimal valorSaque = scanner.nextBigDecimal();
                try {
                    if (contas.get(0).sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso");
                    } else {
                        System.out.println("Saque não pode ser realizado. Verifique seu saldo. ");
                    }
                } catch (SaldoInsuficienteException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "3":
                System.out.println("Digite o nome da Conta de Destino: "); // Código para transferência
                int numeroContaDestino = scanner.nextInt();
                Conta contaDestino = null;
                for (Conta conta : contas) {
                    if (conta.getNumero() == numeroContaDestino) {
                        contaDestino = conta;
                        break;
                    }
                }
                if ( contaDestino == null) {
                    System.out.println("Conta de destino não encontrada. ");
                    break;
                }
                System.out.println("Digite o valor da transferência: ");
                BigDecimal valorTransferencia = scanner.nextBigDecimal();
                try {
                    contas.get(0).transferir(contaDestino, valorTransferencia); //supodo que esta usando a primeira conta do cliente.
                    System.out.println("Transferencia realizada com sucesso");
                } catch (SaldoInsuficienteException e) {
                    System.out.println(e.getMessage());
                }
            case "4":
                System.out.println("Extrato"); // Código para exibir extrato
                contas.get(0).exibirExtrato();
                break;
            case "5":
                System.out.println("Aplicar "); // Código para aplicar rendimento
                if (contas.get(0) instanceof ContaInvestimento){
                    System.out.println("Rendimento aplicando com sucesso.");
                } else {
                    System.out.println("Operação disponivel apenas para investimento. ");
                }
                break;
            case "6":
                System.out.println("Encerando o Sistema. Obrigado por escolher noso Banco!");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. escolha uma opção valida! ");
        }
    }
}

