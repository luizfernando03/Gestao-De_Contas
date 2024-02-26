import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(int numero, BigDecimal saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }

    // Método depositar
    @Override
    public void depositar(BigDecimal valor){
        saldo = saldo.add(valor);
        adicionarTransacao("Depósito realizado com sucesso ", valor);
    }

    // Méto para Saque
    @Override
    public boolean sacar(BigDecimal valor) throws SaldoInsuficienteException{
        if (valor.compareTo(saldo) > 0 ) {
            throw new SaldoInsuficienteException("Saldo insuficiente na conta " + numero + ".");
        } else {
            saldo = saldo.subtract(valor);
            return true;
        }
    }
    // Mètodo transferir para Conta Poupança
    @Override
    public void transferir(Conta destino, BigDecimal valor) throws SaldoInsuficienteException{
        if (this.sacar(valor)){
            destino.depositar(valor);
            adicionarTransacao("Transferência realizada com sucesso para conta " + destino.getNumero(),valor);
        }
    }



}
