package uemg.model;

public class EmprestimosModel extends LeitoresModel{
    
    //Atributos da classe:
    private String cpf_leitor;
    private String nome_obra;
    private String dt_emprestimo;
    private String dt_devolucao;

    //Construtor vazio e sobrecarregado:
    public EmprestimosModel() {
    }

    public EmprestimosModel(String cpf_leitor, String nome_obra, String dt_emprestimo, String dt_devolucao, String cpf, String nome, String email, String telefone, String endereco) {
        super(cpf, nome, email, telefone, endereco);
        this.cpf_leitor = cpf_leitor;
        this.nome_obra = nome_obra;
        this.dt_emprestimo = dt_emprestimo;
        this.dt_devolucao = dt_devolucao;
    }

    //Métodos GET e SET:
    public String getCpf_leitor() {
        return cpf_leitor;
    }

    public void setCpf_leitor(String cpf_leitor) {
        this.cpf_leitor = cpf_leitor;
    }

    public String getNome_obra() {
        return nome_obra;
    }

    public void setNome_obra(String nome_obra) {
        this.nome_obra = nome_obra;
    }

    public String getDt_emprestimo() {
        return dt_emprestimo;
    }

    public void setDt_emprestimo(String dt_emprestimo) {
        this.dt_emprestimo = dt_emprestimo;
    }

    public String getDt_devolucao() {
        return dt_devolucao;
    }

    public void setDt_devolucao(String dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }
    
    
}
