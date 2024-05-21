package fiap.tds.infraestructure;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public static final String URL_CONNECTION = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    public static final String USER = "rm554018";
    public static final String PASSWORD = "170404";

    private final Connection connection;

    public ConexaoBD() {
        try {
            this.connection = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar com o banco: ",e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
