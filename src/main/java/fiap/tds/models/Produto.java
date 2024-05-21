package fiap.tds.models;

import java.sql.Date;

public class Produto {
    private int Id_Produto;
    private String Nome_Produto;
    private String Categoria_Produto;
    private String Doc_Tecnica;
    private Date Dt_Fim;
    private Date Dt_Inicio;
    private String Renovacao;

    public int getId_Produto() {
        return Id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        Id_Produto = id_Produto;
    }

    public String getNome_Produto() {
        return Nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        Nome_Produto = nome_Produto;
    }

    public String getCategoria_Produto() {
        return Categoria_Produto;
    }

    public void setCategoria_Produto(String categoria_Produto) {
        Categoria_Produto = categoria_Produto;
    }

    public String getDoc_Tecnica() {
        return Doc_Tecnica;
    }

    public void setDoc_Tecnica(String doc_Tecnica) {
        Doc_Tecnica = doc_Tecnica;
    }

    public Date getDt_Fim() {
        return Dt_Fim;
    }

    public void setDt_Fim(Date dt_Fim) {
        Dt_Fim = dt_Fim;
    }

    public Date getDt_Inicio() {
        return Dt_Inicio;
    }

    public void setDt_Inicio(Date dt_Inicio) {
        Dt_Inicio = dt_Inicio;
    }

    public String getRenovacao() {
        return Renovacao;
    }

    public void setRenovacao(String renovacao) {
        Renovacao = renovacao;
    }

    public Produto() {
    }

    public Produto(int id_Produto, String nome_Produto, String categoria_Produto, String doc_Tecnica, Date dt_Fim, Date dt_Inicio, String renovacao) {
        Id_Produto = id_Produto;
        Nome_Produto = nome_Produto;
        Categoria_Produto = categoria_Produto;
        Doc_Tecnica = doc_Tecnica;
        Dt_Fim = dt_Fim;
        Dt_Inicio = dt_Inicio;
        Renovacao = renovacao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Id_Produto=" + Id_Produto +
                ", Nome_Produto='" + Nome_Produto + '\'' +
                ", Categoria_Produto='" + Categoria_Produto + '\'' +
                ", Doc_Tecnica='" + Doc_Tecnica + '\'' +
                ", Dt_Fim=" + Dt_Fim +
                ", Dt_Inicio=" + Dt_Inicio +
                ", Renovacao='" + Renovacao + '\'' +
                '}';
    }
}
