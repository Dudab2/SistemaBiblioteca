package dao;

import database.Conexao;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class livroDAO {

    public void cadastrar(Livro livro) {

       String sql = "INSERT INTO livros (titulo, autor, isbn, disponivel) "
           + "VALUES (?, ?, ?, ?)";

        try (
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {

           stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getIsbn());
            stmt.setBoolean(4, livro.isDisponivel());

            stmt.executeUpdate();

            System.out.println("Livro salvo no banco de dados!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar livro no banco:");
            System.out.println(e.getMessage());
        }
    }
}