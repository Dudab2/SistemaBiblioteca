package dao;

import database.Conexao;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Usuario> listarUsuarios() {

    List<Usuario> usuarios = new ArrayList<>();

    String sql = "SELECT * FROM usuarios";

    Connection conexao = Conexao.conectar();

    if (conexao == null) {
        return usuarios;
    }

    try {
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        while (resultado.next()) {

            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            String email = resultado.getString("email");

            Usuario usuario = new Usuario(id, nome, email);

            usuarios.add(usuario);
        }

        resultado.close();
        stmt.close();
        conexao.close();

    } catch (SQLException e) {
        System.out.println(
            "Erro ao listar usuarios: " + e.getMessage()
        );
    }
    return usuarios;
    }
}