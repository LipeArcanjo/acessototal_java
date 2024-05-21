package fiap.tds.models;

public class Industria {
    private int Id_Ind ;
    private String Nome_ind ;
    private String Tipo_Ind  ;
    private String Estado ;

    public int getId_Ind() {
        return Id_Ind;
    }

    public void setId_Ind(int id_Ind) {
        Id_Ind = id_Ind;
    }

    public String getNome_ind() {
        return Nome_ind;
    }

    public void setNome_ind(String nome_ind) {
        Nome_ind = nome_ind;
    }

    public String getTipo_Ind() {
        return Tipo_Ind;
    }

    public void setTipo_Ind(String tipo_Ind) {
        Tipo_Ind = tipo_Ind;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Industria() {
    }

    public Industria(int id_Ind, String nome_ind, String tipo_Ind, String estado) {
        Id_Ind = id_Ind;
        Nome_ind = nome_ind;
        Tipo_Ind = tipo_Ind;
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Industria{" +
                "Id_Ind=" + Id_Ind +
                ", Nome_ind='" + Nome_ind + '\'' +
                ", Tipo_Ind='" + Tipo_Ind + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
