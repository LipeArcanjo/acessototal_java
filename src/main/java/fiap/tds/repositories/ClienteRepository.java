package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private final ConexaoBD dbConnection;

    public ClienteRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<Cliente> getClientesAll() {
        List<Cliente> clientesList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Cliente");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                clientesList.add(new Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getInt("Num_tel"),
                        rs.getDate("Data_nasc"),
                        rs.getString("Acessibilidade"),
                        rs.getInt("Tipo_Cliente"),
                        rs.getString("E_mail"),
                        rs.getString("Idioma"),
                        rs.getDate("Dt_registro"),
                        rs.getString("Endc"),
                        rs.getInt("Senha")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientesList;
    }

    public Cliente getClienteById(int id) {
        Cliente cliente = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Cliente WHERE Id_Cliente = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("Id_Cliente"),
                        rs.getInt("Num_tel"),
                        rs.getDate("Data_nasc"),
                        rs.getString("Acessibilidade"),
                        rs.getInt("Tipo_Cliente"),
                        rs.getString("E_mail"),
                        rs.getString("Idioma"),
                        rs.getDate("Dt_registro"),
                        rs.getString("Endc"),
                        rs.getInt("Senha"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public void createCliente(Cliente cliente) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO Cliente (Id_Cliente, Num_tel, Data_nasc, Acessibilidade, Tipo_Cliente, E_mail, Idioma, Dt_registro, Endc, Senha) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, cliente.getId_Cliente());
            stmt.setInt(2, cliente.getNum_tel());
            stmt.setDate(3, new java.sql.Date(cliente.getData_nasc().getTime()));
            stmt.setString(4, cliente.getAcessibilidade());
            stmt.setInt(5, cliente.getTipo_Cliente());
            stmt.setString(6, cliente.getE_mail());
            stmt.setString(7, cliente.getIdioma());
            stmt.setDate(8, new java.sql.Date(cliente.getDt_registro().getTime()));
            stmt.setString(9, cliente.getEndc());
            stmt.setInt(10, cliente.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCliente(Cliente cliente, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE Cliente SET Id_Cliente = ?, Num_tel = ?, Data_nasc = ?, Acessibilidade = ?, Tipo_Cliente = ?, E_mail = ?, Idioma = ?, Dt_registro = ?, Endc = ?, Senha = ? WHERE Id_Cliente = ?");
            stmt.setInt(11, id);
            stmt.setInt(1, cliente.getId_Cliente());
            stmt.setInt(2, cliente.getNum_tel());
            stmt.setDate(3, new java.sql.Date(cliente.getData_nasc().getTime()));
            stmt.setString(4, cliente.getAcessibilidade());
            stmt.setInt(5, cliente.getTipo_Cliente());
            stmt.setString(6, cliente.getE_mail());
            stmt.setString(7, cliente.getIdioma());
            stmt.setDate(8, new java.sql.Date(cliente.getDt_registro().getTime()));
            stmt.setString(9, cliente.getEndc());
            stmt.setInt(10, cliente.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCliente(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Cliente WHERE Id_Cliente = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
