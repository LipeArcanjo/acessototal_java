package fiap.tds.models;

import java.sql.Date;

public class Midia {
    private int Id_Midia;
    private String Titulo_Midia;
    private String Tipo_midia;
    private String URL_;
    private Date Dt_Publicacao;

    public int getId_Midia() {
        return Id_Midia;
    }

    public void setId_Midia(int id_Midia) {
        Id_Midia = id_Midia;
    }

    public String getTitulo_Midia() {
        return Titulo_Midia;
    }

    public void setTitulo_Midia(String titulo_Midia) {
        Titulo_Midia = titulo_Midia;
    }

    public String getTipo_midia() {
        return Tipo_midia;
    }

    public void setTipo_midia(String tipo_midia) {
        Tipo_midia = tipo_midia;
    }

    public String getURL_() {
        return URL_;
    }

    public void setURL_(String URL_) {
        this.URL_ = URL_;
    }

    public Date getDt_Publicacao() {
        return Dt_Publicacao;
    }

    public void setDt_Publicacao(Date dt_Publicacao) {
        Dt_Publicacao = dt_Publicacao;
    }

    public Midia() {
    }

    public Midia(int id_Midia, String titulo_Midia, String tipo_midia, String URL_, Date dt_Publicacao) {
        Id_Midia = id_Midia;
        Titulo_Midia = titulo_Midia;
        Tipo_midia = tipo_midia;
        this.URL_ = URL_;
        Dt_Publicacao = dt_Publicacao;
    }

    @Override
    public String toString() {
        return "Midia{" +
                "Id_Midia=" + Id_Midia +
                ", Titulo_Midia='" + Titulo_Midia + '\'' +
                ", Tipo_midia='" + Tipo_midia + '\'' +
                ", URL_='" + URL_ + '\'' +
                ", Dt_Publicacao=" + Dt_Publicacao +
                '}';
    }
}
