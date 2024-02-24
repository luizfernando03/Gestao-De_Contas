import java.math.BigDecimal;
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
        this.extrato = extrato; //Incializa uma lista vazia de extrato.
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
    public abstract void depositar(BigDecimal valor);
}
