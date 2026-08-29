package dao;

import database.Conexao;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario) {

        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        Connection conexao = Conexao.conectar();

        if (conexao == null) {
            System.out.println("Não foi possível cadastrar o usuário.");
            return;
        }
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            stmt.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}