import java.util.List;

public class Cliente {
    private String nome;
    private String documento;  // CPF ou CNPJ
    private  TipoConta tipo;  // Pessoa Fisica ou Pessoa Juridica.
    private List<Conta> contas;

}
