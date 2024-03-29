import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    protected int numero; // Número da conta
    protected BigDecimal saldo;
    protected Cliente cliente;
    protected List<String> extrato; //Lista para armazenar o extrato de transaçoes.

    public Conta(int numero, BigDecimal saldo, Cliente cliente, List<String> extrato) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.extrato = new ArrayList<>(); //Incializa uma lista vazia de extrato.
    }

    public Conta(int numero, BigDecimal saldo, Cliente cliente) {
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    // Métodos para realizar operações especificas.
    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
        adicionarTransacao("Deposito realizado com sucesso ", valor);
    }

    public boolean sacar(BigDecimal valor) throws SaldoInsuficienteException {
        if (valor.compareTo(saldo) > 0){
            throw new SaldoInsuficienteException("Saldo insuficiente na conta " + numero + ".");
        } else {
            saldo = saldo.subtract(valor);
            adicionarTransacao("Saque realizado com sucesso " , valor);
            return true;
        }
    }

    public void transferir(Conta destino, BigDecimal valor) throws SaldoInsuficienteException{
        if (this.sacar(valor)) {
            destino.depositar(valor);
            adicionarTransacao("Trasação realizada com sucesso para conta " + destino.getNumero(), valor);

        }
    }

    // Método adicona transação ao extrato.
    protected void adicionarTransacao(String descricao, BigDecimal valor) {
        extrato.add(descricao + " - Valor: " + valor + " - Saldo: " + saldo );
    }

    // Metodo para exibir o extrato
    public void exibirExtrato(){
        System.out.println("=====Extrato da Conta =====");
        for (String trasacao : extrato){
            System.out.println(trasacao);
        }
        System.out.println("===============================================");
    }
}
