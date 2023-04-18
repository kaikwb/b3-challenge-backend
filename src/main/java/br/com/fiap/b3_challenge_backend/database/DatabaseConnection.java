package br.com.fiap.b3_challenge_backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    public static Connection connect(String user, String pass) throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ignored) {
            throw new SQLException("Can't load driver");
        }

        return DriverManager.getConnection(URL, user, pass);
    }
}
