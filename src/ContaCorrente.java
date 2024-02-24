import java.math.BigDecimal;
import java.util.List;

public class ContaCorrente extends Conta {
    private static final BigDecimal TAXA_SAQUE_PJ = new BigDecimal("0.005"); //Taxa para saque para PJ

    public ContaCorrente(int numero, BigDecimal saldo, Cliente cliente, List<String> extrato) {
        super(numero, saldo, cliente, extrato);
    }

    // Metodo Sacar ,  ultilizamos a condição ternaria , essa condiçao é mais concisa para atibuir um valor,
    // onde se o clinte.getTipo for PJ recebe 'taxa' TAXA_SAQUE_PJ , caso o ontrario
    //  a variavel taxa recebera o valor 'BigDecimal.ZERO', que representa zero.
    public boolean sacar(BigDecimal valor) throws SaldoInsuficienteException {
        BigDecimal taxa = cliente.getTipo() == TipoClioente.PESSOA_JURIDICA ? TAXA_SAQUE_PJ : BigDecimal.ZERO;
        BigDecimal valorComTaxa= valor.add(saldo.multiply(taxa));
        if (valorComTaxa.compareTo(saldo) > 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente na conta " + numero + ".");
        } else {
            saldo = saldo.subtract(valorComTaxa);
            return true;
        }
    }
    public void depositar(BigDecimal valor) {
        saldo =saldo.add(valor);
        adicionarTransacao("Deposito realizado com sucesso " + destino.getNumero(), valor);
    }

}
