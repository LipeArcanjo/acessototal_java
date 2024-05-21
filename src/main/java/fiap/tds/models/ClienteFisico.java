package fiap.tds.models;

public class ClienteFisico {
    private int Id_ClienteF;
    private int RG;
    private String Cargo;
    private int CPF;

    // Getters and Setters

    public int getId_ClienteF() {
        return Id_ClienteF;
    }

    public void setId_ClienteF(int id_ClienteF) {
        Id_ClienteF = id_ClienteF;
    }

    public int getRG() {
        return RG;
    }

    public void setRG(int RG) {
        this.RG = RG;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    // Construtores
    // Vazio
    public ClienteFisico() {
    }

    // Cheio
    public ClienteFisico(int id_ClienteF, int RG, String cargo, int CPF) {
        Id_ClienteF = id_ClienteF;
        this.RG = RG;
        Cargo = cargo;
        this.CPF = CPF;
    }

    // toString
    @Override
    public String toString() {
        return "ClienteFisico{" +
                "Id_ClienteF=" + Id_ClienteF +
                ", RG=" + RG +
                ", Cargo='" + Cargo + '\'' +
                ", CPF=" + CPF +
                '}';
    }
}
