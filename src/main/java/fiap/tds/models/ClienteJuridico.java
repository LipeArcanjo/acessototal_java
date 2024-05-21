package fiap.tds.models;

public class ClienteJuridico {
    private int Id_ClienteJ;
    private String Nome_emp;
    private int CNPJ;
    private String E_mail;

    // Getters and Setters
    public int getId_ClienteJ() {
        return Id_ClienteJ;
    }

    public void setId_ClienteJ(int id_ClienteJ) {
        Id_ClienteJ = id_ClienteJ;
    }

    public String getNome_emp() {
        return Nome_emp;
    }

    public void setNome_emp(String nome_emp) {
        Nome_emp = nome_emp;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }


    // Construtores
    // Vazio
    public ClienteJuridico() {
    }

    // Cheio
    public ClienteJuridico(int id_ClienteJ, String nome_emp, int CNPJ, String e_mail) {
        Id_ClienteJ = id_ClienteJ;
        Nome_emp = nome_emp;
        this.CNPJ = CNPJ;
        E_mail = e_mail;
    }

    // toString

    @Override
    public String toString() {
        return "ClienteJuridico{" +
                "Id_ClienteJ=" + Id_ClienteJ +
                ", Nome_emp='" + Nome_emp + '\'' +
                ", CNPJ=" + CNPJ +
                ", E_mail='" + E_mail + '\'' +
                '}';
    }
}
