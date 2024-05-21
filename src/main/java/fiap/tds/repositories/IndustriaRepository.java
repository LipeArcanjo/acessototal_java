package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.Industria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndustriaRepository {
    private final ConexaoBD dbConnection;

    public IndustriaRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<Industria> getIndustriasAll() {
        List<Industria> industriasList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Industria");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                industriasList.add(new Industria(
                        rs.getInt("Id_Ind"),
                        rs.getString("Nome_ind"),
                        rs.getString("Tipo_Ind"),
                        rs.getString("Estado")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return industriasList;
    }

    public Industria getIndustriaById(int id) {
        Industria industria = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Industria WHERE Id_Ind = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                industria = new Industria(
                        rs.getInt("Id_Ind"),
                        rs.getString("Nome_ind"),
                        rs.getString("Tipo_Ind"),
                        rs.getString("Estado"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return industria;
    }

    public void createIndustria(Industria industria) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO Industria (Id_Ind, Nome_ind, Tipo_Ind, Estado) VALUES (?,?,?,?)");
            stmt.setInt(1, industria.getId_Ind());
            stmt.setString(2, industria.getNome_ind());
            stmt.setString(3, industria.getTipo_Ind());
            stmt.setString(4, industria.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateIndustria(Industria industria, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE Industria SET Id_Ind = ?, Nome_ind = ?, Tipo_Ind = ?, Estado = ? WHERE Id_Ind = ?");
            stmt.setInt(5, id);
            stmt.setInt(1, industria.getId_Ind());
            stmt.setString(2, industria.getNome_ind());
            stmt.setString(3, industria.getTipo_Ind());
            stmt.setString(4, industria.getEstado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteIndustria(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Industria WHERE Id_Ind = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
