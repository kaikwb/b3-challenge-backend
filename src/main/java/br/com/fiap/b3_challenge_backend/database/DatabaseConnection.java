package br.com.fiap.b3_challenge_backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String DATABASE_USER = "rm96731";
    private static final String DATABASE_PASS = "161193";

    private static Connection connection = null;

    /**
     * Cria e retorna a conexão com o banco de dados, caso já tenha uma conexão aberta retorna a mesma conexão.
     *
     * @return Retorna a conexão com o banco de dados
     * @throws SQLException — Exceção lançada em erros de conexão com o banco de dados
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ignored) {
                throw new SQLException("Can't load driver");
            }

            connection = DriverManager.getConnection(URL, DATABASE_USER, DATABASE_PASS);
        }

        return connection;
    }
}
