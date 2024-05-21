package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.ClienteFisico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteFisicoRepository {
    private final ConexaoBD dbConnection;

    public ClienteFisicoRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<ClienteFisico> getClientesFisicosAll() {
        List<ClienteFisico> clientesFisicosList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM ClienteFisico");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                clientesFisicosList.add(new ClienteFisico(
                        rs.getInt("Id_ClienteF"),
                        rs.getInt("RG"),
                        rs.getString("Cargo"),
                        rs.getInt("CPF")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientesFisicosList;
    }

    public ClienteFisico getClienteFisicoById(int id) {
        ClienteFisico clienteFisico = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM ClienteFisico WHERE Id_ClienteF = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                clienteFisico = new ClienteFisico(
                        rs.getInt("Id_ClienteF"),
                        rs.getInt("RG"),
                        rs.getString("Cargo"),
                        rs.getInt("CPF"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clienteFisico;
    }

    public void createClienteFisico(ClienteFisico clienteFisico) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO ClienteFisico (Id_ClienteF, RG, Cargo, CPF) VALUES (?,?,?,?)");
            stmt.setInt(1, clienteFisico.getId_ClienteF());
            stmt.setInt(2, clienteFisico.getRG());
            stmt.setString(3, clienteFisico.getCargo());
            stmt.setInt(4, clienteFisico.getCPF());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateClienteFisico(ClienteFisico clienteFisico, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE ClienteFisico SET Id_ClienteF = ?, RG = ?, Cargo = ?, CPF = ? WHERE Id_ClienteF = ?");
            stmt.setInt(5, id);
            stmt.setInt(1, clienteFisico.getId_ClienteF());
            stmt.setInt(2, clienteFisico.getRG());
            stmt.setString(3, clienteFisico.getCargo());
            stmt.setInt(4, clienteFisico.getCPF());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteClienteFisico(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM ClienteFisico WHERE Id_ClienteF = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
