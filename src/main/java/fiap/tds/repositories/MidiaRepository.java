package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.Midia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MidiaRepository {
    private final ConexaoBD dbConnection;

    public MidiaRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<Midia> getMidiasAll() {
        List<Midia> midiasList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT Id_Midia, Titulo_Midia, Tipo_midia, URL_, Dt_Publicacao FROM Midia");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                midiasList.add(new Midia(
                        rs.getInt("Id_Midia"),
                        rs.getString("Titulo_Midia"),
                        rs.getString("Tipo_midia"),
                        rs.getString("URL_"),
                        rs.getDate("Dt_Publicacao")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as mídias", e);
        }
        return midiasList;
    }

    public Midia getMidiaById(int id) {
        Midia midia = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Midia WHERE Id_Midia = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                midia = new Midia(
                        rs.getInt("Id_Midia"),
                        rs.getString("Titulo_Midia"),
                        rs.getString("Tipo_midia"),
                        rs.getString("URL_"),
                        rs.getDate("Dt_Publicacao"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return midia;
    }

    public void createMidia(Midia midia) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO Midia (Id_Midia, Titulo_Midia, Tipo_midia, URL_, Dt_Publicacao) VALUES (?,?,?,?,?)");
            stmt.setInt(1, midia.getId_Midia());
            stmt.setString(2, midia.getTitulo_Midia());
            stmt.setString(3, midia.getTipo_midia());
            stmt.setString(4, midia.getURL_());
            stmt.setDate(5, new java.sql.Date(midia.getDt_Publicacao().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMidia(Midia midia, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE Midia SET Id_Midia = ?, Titulo_Midia = ?, Tipo_midia = ?, URL_ = ?, Dt_Publicacao = ? WHERE Id_Midia = ?");
            stmt.setInt(6, id);
            stmt.setInt(1, midia.getId_Midia());
            stmt.setString(2, midia.getTitulo_Midia());
            stmt.setString(3, midia.getTipo_midia());
            stmt.setString(4, midia.getURL_());
            stmt.setDate(5, new java.sql.Date(midia.getDt_Publicacao().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMidia(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Midia WHERE Id_Midia = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
