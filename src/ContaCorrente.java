import java.math.BigDecimal;
import java.util.List;

public class ContaCorrente extends Conta{
    private static final BigDecimal TAXA_SAQUE_PJ = new BigDecimal("0.005"); //Taxa para saque para PJ

    public ContaCorrente(int numero, BigDecimal saldo, Cliente cliente, List<String> extrato) {
        super(numero, saldo, cliente, extrato);
    }
    //Metodo Sacar
    public boolean sacar(BigDecimal valor) throws SaldoInsuficienteException {

    }
}
