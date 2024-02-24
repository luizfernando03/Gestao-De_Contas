import java.math.BigDecimal;
import java.util.List;

public class ContaInvestimento extends Conta{

    public ContaInvestimento(int numero, BigDecimal saldo, Cliente cliente, List<String> extrato) {
        super(numero, saldo, cliente, extrato);
    }

    // Método para Saque da Conta Investimento
    public boolean sacar(BigDecimal valor) throws SaldoInsuficienteException {
        if (valor.compareTo(saldo) > 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente na Conta " + numero +);
        } else {
            saldo = saldo.subtract(valor);
            adicionarTransacao("Saque realizado com sucesso ", valor);
            return true;
        }
    }

    // Método de transferir para Conta Investimento
}
