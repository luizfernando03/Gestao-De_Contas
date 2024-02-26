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
                // Código para dpósito
                break;
            case "2":
                // Código para saque
                break;
            case "3":
                // Código para transferência
                break;
            case "4":
                // Código para exibir extrato
                break;
            case "5":
                // Código para aplicar rendimento
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

