package fiap.tds.repositories;

import fiap.tds.infraestructure.ConexaoBD;
import fiap.tds.models.Blog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogRepository {
    private final ConexaoBD dbConnection;

    public BlogRepository(){
        this.dbConnection = new ConexaoBD();
    }

    public List<Blog> getBlogsAll() {
        List<Blog> blogsList = new ArrayList<>();
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Blog");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                blogsList.add(new Blog(
                        rs.getInt("Id_Blog"),
                        rs.getString("Titulo_Blog"),
                        rs.getString("Conteudo_Blog"),
                        rs.getDate("Dt_Publicacao"),
                        rs.getString("Produto"),
                        rs.getString("Cliente")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return blogsList;
    }

    public Blog getBlogById(int id) {
        Blog blog = null;
        try {
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("SELECT * FROM Blog WHERE Id_Blog = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                blog = new Blog(
                        rs.getInt("Id_Blog"),
                        rs.getString("Titulo_Blog"),
                        rs.getString("Conteudo_Blog"),
                        rs.getDate("Dt_Publicacao"),
                        rs.getString("Produto"),
                        rs.getString("Cliente"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return blog;
    }

    public void createBlog(Blog blog) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("INSERT INTO Blog (Id_Blog, Titulo_Blog, Conteudo_Blog, Dt_Publicacao, Produto, Cliente) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, blog.getId_Blog());
            stmt.setString(2, blog.getTitulo_Blog());
            stmt.setString(3, blog.getConteudo_Blog());
            stmt.setDate(4, new java.sql.Date(blog.getDt_Publicacao().getTime()));
            stmt.setString(5, blog.getProduto());
            stmt.setString(6, blog.getCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBlog(Blog blog, int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("UPDATE Blog SET Id_Blog = ?, Titulo_Blog = ?, Conteudo_Blog = ?, Dt_Publicacao = ?, Produto = ?, Cliente = ? WHERE Id_Blog = ?");
            stmt.setInt(7, id);
            stmt.setInt(1, blog.getId_Blog());
            stmt.setString(2, blog.getTitulo_Blog());
            stmt.setString(3, blog.getConteudo_Blog());
            stmt.setDate(4, new java.sql.Date(blog.getDt_Publicacao().getTime()));
            stmt.setString(5, blog.getProduto());
            stmt.setString(6, blog.getCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBlog(int id) {
        try{
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement("DELETE FROM Blog WHERE Id_Blog = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
