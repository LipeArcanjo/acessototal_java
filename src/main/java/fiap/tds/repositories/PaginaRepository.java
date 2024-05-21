package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.Pagina;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PaginaRepository {
    private final ConexaoBD dbConnection;

    public PaginaRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<Pagina> getPaginasAll() {
        List<Pagina> paginasList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Pagina");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                paginasList.add(new Pagina(
                        rs.getInt("Id_Pag"),
                        rs.getString("Titulo_Pag"),
                        rs.getString("Conteudo_Pag"),
                        rs.getDate("Dt_Criacao")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paginasList;
    }

    public Pagina getPaginaById(int id) {
        Pagina pagina = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Pagina WHERE Id_Pag = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pagina = new Pagina(
                        rs.getInt("Id_Pag"),
                        rs.getString("Titulo_Pag"),
                        rs.getString("Conteudo_Pag"),
                        rs.getDate("Dt_Criacao"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pagina;
    }


    public void createPagina(Pagina pagina) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO Pagina (Id_Pag, Titulo_Pag, Conteudo_Pag, Dt_Criacao) VALUES (?,?,?,?)");
            stmt.setInt(1, pagina.getId_Pag());
            stmt.setString(2, pagina.getTitulo_Pag());
            stmt.setString(3, pagina.getConteudo_Pag());
            stmt.setDate(4, new java.sql.Date(pagina.getDt_Criacao().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updatePagina(Pagina pagina, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE Pagina SET Id_Pag = ?, Titulo_Pag = ?, Conteudo_Pag = ?, Dt_Criacao = ? WHERE Id_Pag = ?");
            stmt.setInt(5, id);
            stmt.setInt(1, pagina.getId_Pag());
            stmt.setString(2, pagina.getTitulo_Pag());
            stmt.setString(3, pagina.getConteudo_Pag());
            stmt.setDate(4, new java.sql.Date(pagina.getDt_Criacao().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePagina(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Pagina WHERE Id_Pag = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
