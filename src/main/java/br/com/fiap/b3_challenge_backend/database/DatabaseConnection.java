package br.com.fiap.b3_challenge_backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String DATABASE_USER = "USER";
    private static final String DATABASE_PASS = "PASSWORD";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
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
