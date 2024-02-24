import java.math.BigDecimal;
import java.util.List;

public class ContaInvestimento extends Conta{
    private static final BigDecimal REDIMENTO_EXTRA_PF = new BigDecimal("0.02"); //Rendimento pessoa PF
    private static final BigDecimal REDIMENTO_EXTRA_PJ = new BigDecimal("0.04"); //Rendimento dobrado pessoa PJ

    public ContaInvestimento(int numero, BigDecimal saldo, Cliente cliente, List<String> extrato) {
        super(numero, saldo, cliente, extrato);
    }

    // Método depositar para Conta Investimento
    @Override
    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
        adicionarTransacao("Deposito realizado com sucesso ", valor);
    }

    // Método para Saque da Conta Investimento
    @Override
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
    @Override
    public void transferir(Conta destino, BigDecimal valor) throws SaldoInsuficienteException {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            adicionarTransacao("Transferencia aplicada com sucesso " rendimneto);
        }
    }
}
