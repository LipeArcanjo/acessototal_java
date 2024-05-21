package fiap.tds.models;

import java.sql.Date;

public class Pagina {
    private int Id_Pag;
    private String Titulo_Pag;
    private String Conteudo_Pag;
    private Date Dt_Criacao;

    public int getId_Pag() {
        return Id_Pag;
    }

    public void setId_Pag(int id_Pag) {
        Id_Pag = id_Pag;
    }

    public String getTitulo_Pag() {
        return Titulo_Pag;
    }

    public void setTitulo_Pag(String titulo_Pag) {
        Titulo_Pag = titulo_Pag;
    }

    public String getConteudo_Pag() {
        return Conteudo_Pag;
    }

    public void setConteudo_Pag(String conteudo_Pag) {
        Conteudo_Pag = conteudo_Pag;
    }

    public Date getDt_Criacao() {
        return Dt_Criacao;
    }

    public void setDt_Criacao(Date dt_Criacao) {
        Dt_Criacao = dt_Criacao;
    }

    public Pagina() {
    }

    public Pagina(int id_Pag, String titulo_Pag, String conteudo_Pag, Date dt_Criacao) {
        Id_Pag = id_Pag;
        Titulo_Pag = titulo_Pag;
        Conteudo_Pag = conteudo_Pag;
        Dt_Criacao = dt_Criacao;
    }

    @Override
    public String toString() {
        return "Pagina{" +
                "Id_Pag=" + Id_Pag +
                ", Titulo_Pag='" + Titulo_Pag + '\'' +
                ", Conteudo_Pag='" + Conteudo_Pag + '\'' +
                ", Dt_Criacao=" + Dt_Criacao +
                '}';
    }
}
