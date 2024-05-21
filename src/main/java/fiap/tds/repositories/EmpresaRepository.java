package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaRepository {
    private final ConexaoBD dbConnection;

    public EmpresaRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<Empresa> getEmpresasAll() {
        List<Empresa> empresasList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Empresa");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                empresasList.add(new Empresa(
                        rs.getString("Endc"),
                        rs.getInt("Num_Tel"),
                        rs.getInt("Id_Emp"),
                        rs.getString("Nome_Emp"),
                        rs.getInt("CNPJ"),
                        rs.getInt("Qnt_licencas"),
                        rs.getString("Estado")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empresasList;
    }

    public Empresa getEmpresaById(int id) {
        Empresa empresa = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Empresa WHERE Id_Emp = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                empresa = new Empresa(
                        rs.getString("Endc"),
                        rs.getInt("Num_Tel"),
                        rs.getInt("Id_Emp"),
                        rs.getString("Nome_Emp"),
                        rs.getInt("CNPJ"),
                        rs.getInt("Qnt_licencas"),
                        rs.getString("Estado"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empresa;
    }

    public void createEmpresa(Empresa empresa) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO Empresa (Endc, Num_Tel, Id_Emp, Nome_Emp, CNPJ, Qnt_licencas, Estado) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, empresa.getEndc());
            stmt.setInt(2, empresa.getNum_Tel());
            stmt.setInt(3, empresa.getId_Emp());
            stmt.setString(4, empresa.getNome_Emp());
            stmt.setInt(5, empresa.getCNPJ());
            stmt.setInt(6, empresa.getQnt_licencas());
            stmt.setString(7, empresa.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmpresa(Empresa empresa, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE Empresa SET Endc = ?, Num_Tel = ?, Id_Emp = ?, Nome_Emp = ?, CNPJ = ?, Qnt_licencas = ?, Estado = ? WHERE Id_Emp = ?");
            stmt.setInt(8, id);
            stmt.setString(1, empresa.getEndc());
            stmt.setInt(2, empresa.getNum_Tel());
            stmt.setInt(3, empresa.getId_Emp());
            stmt.setString(4, empresa.getNome_Emp());
            stmt.setInt(5, empresa.getCNPJ());
            stmt.setInt(6, empresa.getQnt_licencas());
            stmt.setString(7, empresa.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmpresa(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Empresa WHERE Id_Emp = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
