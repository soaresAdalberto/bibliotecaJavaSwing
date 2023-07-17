package uemg.model;

public class ObrasModel {
    
    //Atributos da minha classe:
    private String Tipo_Periodico;
    private String Categoria_Periodico;
    private String Nome_Obra;
    private String Autor;
    private int Edicao;
    private String Cidade;
    private String Editora;
    private int Paginas;
    private float Cm;
    private String Isbn;
    private String Cdu;
    private int Exemplares;
    private int Ano;
    private String Palavras_Chave;

    //Construtores da minha classe:
    public ObrasModel() {
    }

    public ObrasModel(String Tipo_Periodico, String Categoria_Periodico, String Nome_Obra, String Autor, int Edicao, String Cidade, String Editora, int Paginas, float Cm, String Isbn, String Cdu, int Exemplares, int Ano, String Palavras_Chave) {
        this.Tipo_Periodico = Tipo_Periodico;
        this.Categoria_Periodico = Categoria_Periodico;
        this.Nome_Obra = Nome_Obra;
        this.Autor = Autor;
        this.Edicao = Edicao;
        this.Cidade = Cidade;
        this.Editora = Editora;
        this.Paginas = Paginas;
        this.Cm = Cm;
        this.Isbn = Isbn;
        this.Cdu = Cdu;
        this.Exemplares = Exemplares;
        this.Ano = Ano;
        this.Palavras_Chave = Palavras_Chave;
    }

    //Métodos GET e SET:
    public String getTipo_Periodico() {
        return Tipo_Periodico;
    }

    public void setTipo_Periodico(String Tipo_Periodico) {
        this.Tipo_Periodico = Tipo_Periodico;
    }

    public String getCategoria_Periodico() {
        return Categoria_Periodico;
    }

    public void setCategoria_Periodico(String Categoria_Periodico) {
        this.Categoria_Periodico = Categoria_Periodico;
    }

    public String getNome_Obra() {
        return Nome_Obra;
    }

    public void setNome_Obra(String Nome_Obra) {
        this.Nome_Obra = Nome_Obra;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getEdicao() {
        return Edicao;
    }

    public void setEdicao(int Edicao) {
        this.Edicao = Edicao;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora(String Editora) {
        this.Editora = Editora;
    }

    public int getPaginas() {
        return Paginas;
    }

    public void setPaginas(int Paginas) {
        this.Paginas = Paginas;
    }

    public float getCm() {
        return Cm;
    }

    public void setCm(float Cm) {
        this.Cm = Cm;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public String getCdu() {
        return Cdu;
    }

    public void setCdu(String Cdu) {
        this.Cdu = Cdu;
    }

    public int getExemplares() {
        return Exemplares;
    }

    public void setExemplares(int Exemplares) {
        this.Exemplares = Exemplares;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public String getPalavras_Chave() {
        return Palavras_Chave;
    }

    public void setPalavras_Chave(String Palavras_Chave) {
        this.Palavras_Chave = Palavras_Chave;
    }
}
