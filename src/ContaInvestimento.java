import java.math.BigDecimal;
import java.util.List;

public class ContaInvestimento extends Conta{

    public ContaInvestimento(int numero, BigDecimal saldo, Cliente cliente, List<String> extrato) {
        super(numero, saldo, cliente, extrato);
    }
}
