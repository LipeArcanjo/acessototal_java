package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.ClienteJuridico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteJuridicoRepository {
    private final ConexaoBD dbConnection;

    public ClienteJuridicoRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<ClienteJuridico> getClientesJuridicosAll() {
        List<ClienteJuridico> clientesJuridicosList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM ClienteJuridico");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                clientesJuridicosList.add(new ClienteJuridico(
                        rs.getInt("Id_ClienteJ"),
                        rs.getString("Nome_emp"),
                        rs.getInt("CNPJ"),
                        rs.getString("E_mail")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientesJuridicosList;
    }

    public ClienteJuridico getClienteJuridicoById(int id) {
        ClienteJuridico clienteJuridico = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM ClienteJuridico WHERE Id_ClienteJ = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                clienteJuridico = new ClienteJuridico(
                        rs.getInt("Id_ClienteJ"),
                        rs.getString("Nome_emp"),
                        rs.getInt("CNPJ"),
                        rs.getString("E_mail"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clienteJuridico;
    }

    public void createClienteJuridico(ClienteJuridico clienteJuridico) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO ClienteJuridico (Id_ClienteJ, Nome_emp, CNPJ, E_mail) VALUES (?,?,?,?)");
            stmt.setInt(1, clienteJuridico.getId_ClienteJ());
            stmt.setString(2, clienteJuridico.getNome_emp());
            stmt.setInt(3, clienteJuridico.getCNPJ());
            stmt.setString(4, clienteJuridico.getE_mail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateClienteJuridico(ClienteJuridico clienteJuridico, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE ClienteJuridico SET Id_ClienteJ = ?, Nome_emp = ?, CNPJ = ?, E_mail = ? WHERE Id_ClienteJ = ?");
            stmt.setInt(5, id);
            stmt.setInt(1, clienteJuridico.getId_ClienteJ());
            stmt.setString(2, clienteJuridico.getNome_emp());
            stmt.setInt(3, clienteJuridico.getCNPJ());
            stmt.setString(4, clienteJuridico.getE_mail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteClienteJuridico(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM ClienteJuridico WHERE Id_ClienteJ = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
