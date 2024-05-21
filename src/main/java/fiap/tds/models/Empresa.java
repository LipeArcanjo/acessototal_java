package fiap.tds.models;

public class Empresa {
    private String Endc;
    private int Num_Tel;
    private int Id_Emp;
    private String Nome_Emp;
    private int CNPJ;
    private int Qnt_licencas;
    private String Estado;

    // Getters and Setters


    public String getEndc() {
        return Endc;
    }

    public void setEndc(String endc) {
        Endc = endc;
    }

    public int getNum_Tel() {
        return Num_Tel;
    }

    public void setNum_Tel(int num_Tel) {
        Num_Tel = num_Tel;
    }

    public int getId_Emp() {
        return Id_Emp;
    }

    public void setId_Emp(int id_Emp) {
        Id_Emp = id_Emp;
    }

    public String getNome_Emp() {
        return Nome_Emp;
    }

    public void setNome_Emp(String nome_Emp) {
        Nome_Emp = nome_Emp;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getQnt_licencas() {
        return Qnt_licencas;
    }

    public void setQnt_licencas(int qnt_licencas) {
        Qnt_licencas = qnt_licencas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Empresa() {
    }

    public Empresa(String endc, int num_Tel, int id_Emp, String nome_Emp, int CNPJ, int qnt_licencas, String estado) {
        Endc = endc;
        Num_Tel = num_Tel;
        Id_Emp = id_Emp;
        Nome_Emp = nome_Emp;
        this.CNPJ = CNPJ;
        Qnt_licencas = qnt_licencas;
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "Endc='" + Endc + '\'' +
                ", Num_Tel=" + Num_Tel +
                ", Id_Emp=" + Id_Emp +
                ", Nome_Emp='" + Nome_Emp + '\'' +
                ", CNPJ=" + CNPJ +
                ", Qnt_licencas=" + Qnt_licencas +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
