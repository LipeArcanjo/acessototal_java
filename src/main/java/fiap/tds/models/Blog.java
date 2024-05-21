package fiap.tds.models;

import java.sql.Date;

public class Blog {
    private int Id_Blog;
    private String Titulo_Blog;
    private String Conteudo_Blog;
    private Date Dt_Publicacao;
    private String Produto;
    private String Cliente;

    public int getId_Blog() {
        return Id_Blog;
    }

    public void setId_Blog(int id_Blog) {
        Id_Blog = id_Blog;
    }

    public String getTitulo_Blog() {
        return Titulo_Blog;
    }

    public void setTitulo_Blog(String titulo_Blog) {
        Titulo_Blog = titulo_Blog;
    }

    public String getConteudo_Blog() {
        return Conteudo_Blog;
    }

    public void setConteudo_Blog(String conteudo_Blog) {
        Conteudo_Blog = conteudo_Blog;
    }

    public Date getDt_Publicacao() {
        return Dt_Publicacao;
    }

    public void setDt_Publicacao(Date dt_Publicacao) {
        Dt_Publicacao = dt_Publicacao;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String produto) {
        Produto = produto;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public Blog() {
    }

    public Blog(int id_Blog, String titulo_Blog, String conteudo_Blog, Date dt_Publicacao, String produto, String cliente) {
        Id_Blog = id_Blog;
        Titulo_Blog = titulo_Blog;
        Conteudo_Blog = conteudo_Blog;
        Dt_Publicacao = dt_Publicacao;
        Produto = produto;
        Cliente = cliente;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "Id_Blog=" + Id_Blog +
                ", Titulo_Blog='" + Titulo_Blog + '\'' +
                ", Conteudo_Blog='" + Conteudo_Blog + '\'' +
                ", Dt_Publicacao=" + Dt_Publicacao +
                ", Produto='" + Produto + '\'' +
                ", Cliente='" + Cliente + '\'' +
                '}';
    }
}
