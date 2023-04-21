package br.com.fiap.b3_challenge_backend.api;

import br.com.fiap.b3_challenge_backend.beans.User;
import br.com.fiap.b3_challenge_backend.dao.UserDAO;
import br.com.fiap.b3_challenge_backend.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/users")
public class UserService extends Service<User> {

    public UserService() throws SQLException {
        super(new UserDAO(DatabaseConnection.getConnection()));
    }
}
