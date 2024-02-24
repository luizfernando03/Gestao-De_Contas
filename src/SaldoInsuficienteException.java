public class SaldoInsuficienteException extends Exception {

    // Classe criada para representar uma situação excepcional no código,
    // onde o saldo é menor que o valor de saque solicitado, ou seja o saldo é insuficiente.
    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
}
