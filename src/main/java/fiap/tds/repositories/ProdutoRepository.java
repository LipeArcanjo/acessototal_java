package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private final ConexaoBD dbConnection;

    public ProdutoRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<Produto> getProdutosAll() {
        List<Produto> produtosList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Produto");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                produtosList.add(new Produto(
                        rs.getInt("Id_Produto"),
                        rs.getString("Nome_Produto"),
                        rs.getString("Categoria_Produto"),
                        rs.getString("Doc_Tecnica"),
                        rs.getDate("Dt_Fim"),
                        rs.getDate("Dt_Inicio"),
                        rs.getString("Renovacao")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtosList;
    }

    public Produto getProdutoById(int id) {
        Produto produto = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Produto WHERE Id_Produto = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto(
                        rs.getInt("Id_Produto"),
                        rs.getString("Nome_Produto"),
                        rs.getString("Categoria_Produto"),
                        rs.getString("Doc_Tecnica"),
                        rs.getDate("Dt_Fim"),
                        rs.getDate("Dt_Inicio"),
                        rs.getString("Renovacao"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produto;
    }

    public void createProduto(Produto produto) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO Produto (Id_Produto, Nome_Produto, Categoria_Produto, Doc_Tecnica, Dt_Fim, Dt_Inicio, Renovacao) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, produto.getId_Produto());
            stmt.setString(2, produto.getNome_Produto());
            stmt.setString(3, produto.getCategoria_Produto());
            stmt.setString(4, produto.getDoc_Tecnica());
            stmt.setDate(5, new java.sql.Date(produto.getDt_Fim().getTime()));
            stmt.setDate(6, new java.sql.Date(produto.getDt_Inicio().getTime()));
            stmt.setString(7, produto.getRenovacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProduto(Produto produto, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE Produto SET Id_Produto = ?, Nome_Produto = ?, Categoria_Produto = ?, Doc_Tecnica = ?, Dt_Fim = ?, Dt_Inicio = ?, Renovacao = ? WHERE Id_Produto = ?");
            stmt.setInt(8, id);
            stmt.setInt(1, produto.getId_Produto());
            stmt.setString(2, produto.getNome_Produto());
            stmt.setString(3, produto.getCategoria_Produto());
            stmt.setString(4, produto.getDoc_Tecnica());
            stmt.setDate(5, new java.sql.Date(produto.getDt_Fim().getTime()));
            stmt.setDate(6, new java.sql.Date(produto.getDt_Inicio().getTime()));
            stmt.setString(7, produto.getRenovacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduto(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Produto WHERE Id_Produto = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
