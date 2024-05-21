package fiap.tds.models;

import java.sql.Date;

public class Cliente {
    private int Id_Cliente;
    private int Num_tel;
    private Date Data_nasc;
    private String Acessibilidade;
    private int Tipo_Cliente;
    private String E_mail;
    private String Idioma;
    private Date Dt_registro;
    private String Endc;
    private int Senha;

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public int getNum_tel() {
        return Num_tel;
    }

    public void setNum_tel(int num_tel) {
        Num_tel = num_tel;
    }

    public Date getData_nasc() {
        return Data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        Data_nasc = data_nasc;
    }

    public String getAcessibilidade() {
        return Acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        Acessibilidade = acessibilidade;
    }

    public int getTipo_Cliente() {
        return Tipo_Cliente;
    }

    public void setTipo_Cliente(int tipo_Cliente) {
        Tipo_Cliente = tipo_Cliente;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String idioma) {
        Idioma = idioma;
    }

    public Date getDt_registro() {
        return Dt_registro;
    }

    public void setDt_registro(Date dt_registro) {
        Dt_registro = dt_registro;
    }

    public String getEndc() {
        return Endc;
    }

    public void setEndc(String endc) {
        Endc = endc;
    }

    public int getSenha() {
        return Senha;
    }

    public void setSenha(int senha) {
        Senha = senha;
    }

    public Cliente() {
    }

    public Cliente(int id_Cliente, int num_tel, Date data_nasc, String acessibilidade, int tipo_Cliente, String e_mail, String idioma, Date dt_registro, String endc, int senha) {
        Id_Cliente = id_Cliente;
        Num_tel = num_tel;
        Data_nasc = data_nasc;
        Acessibilidade = acessibilidade;
        Tipo_Cliente = tipo_Cliente;
        E_mail = e_mail;
        Idioma = idioma;
        Dt_registro = dt_registro;
        Endc = endc;
        Senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Id_Cliente=" + Id_Cliente +
                ", Num_tel=" + Num_tel +
                ", Data_nasc=" + Data_nasc +
                ", Acessibilidade='" + Acessibilidade + '\'' +
                ", Tipo_Cliente=" + Tipo_Cliente +
                ", E_mail='" + E_mail + '\'' +
                ", Idioma='" + Idioma + '\'' +
                ", Dt_registro=" + Dt_registro +
                ", Endc='" + Endc + '\'' +
                ", Senha=" + Senha +
                '}';
    }
}
