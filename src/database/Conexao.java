package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mariadb://127.0.0.1:3306/biblioteca";

    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection conectar() {
        try {
            Connection conexao =
                    DriverManager.getConnection(URL, USUARIO, SENHA);

            System.out.println("Conexao com o banco realizada com sucesso!");

            return conexao;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco:");
            System.out.println(e.getMessage());

            return null;
        }
    }
}