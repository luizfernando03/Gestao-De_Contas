import java.util.List;

public class Cliente {
    private String nome;
    private String documento;  // CPF ou CNPJ
    private  TipoConta tipo;  // Pessoa Fisica ou Pessoa Juridica.
    private List<Conta> contas;

    public Cliente(String nome, String documento, TipoConta tipo, List<Conta> contas) {
        this.nome = nome;
        this.documento = documento;
        this.tipo = tipo;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    // Método para abrir  nova Conta
    public void abrirConta()
}
