package br.com.fiap.b3_challenge_backend.dao;

import br.com.fiap.b3_challenge_backend.beans.User;
import jakarta.ws.rs.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final Connection connection;

    private static void setAllFields(PreparedStatement ps, User user) throws SQLException {
        ps.setString(1, user.getName());
        ps.setString(2, user.getCpf());
        ps.setString(3, user.getMail());
        ps.setString(4, user.getPostalCode());
        ps.setString(5, user.getAddress());
        ps.setString(6, user.getNumber());
        ps.setString(7, user.getAddress2());
        ps.setString(8, user.getNeighborhood());
        ps.setString(9, user.getCity());
        ps.setString(10, user.getState());
    }

    private static User createFromResult(ResultSet rs) throws SQLException {
        return new User(
            rs.getInt("ID"),
            rs.getString("NAME"),
            rs.getString("CPF"),
            rs.getString("MAIL"),
            rs.getString("POSTAL_CODE"),
            rs.getString("ADDRESS"),
            rs.getString("NUMBER"),
            rs.getString("ADDRESS2"),
            rs.getString("NEIGHBORHOOD"),
            rs.getString("CITY"),
            rs.getString("STATE")
        );
    }

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User add(User user) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String[] returnId = {"ID"};
            ps = connection.prepareStatement("INSERT INTO USERS (NAME, CPF, MAIL, POSTAL_CODE, ADDRESS, \"NUMBER\", ADDRESS2, NEIGHBORHOOD, CITY, STATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", returnId);
            setAllFields(ps, user);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }

            return user;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    public void update(User user) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE USERS SET NAME = ?, CPF = ?, MAIL = ?, POSTAL_CODE = ?, ADDRESS = ?, \"NUMBER\" = ?, ADDRESS2 = ?, NEIGHBORHOOD = ?, CITY = ?, STATE = ? WHERE ID = ?")) {
            setAllFields(ps, user);
            ps.setInt(10, user.getId());
            int rowAffected = ps.executeUpdate();

            if (rowAffected == 0) {
                throw new NotFoundException(String.format("User ID %d not found.", user.getId()));
            }
        }
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM USERS WHERE ID = ?")) {
            ps.setInt(1, id);
            int rowAffected = ps.executeUpdate();

            if (rowAffected == 0) {
                throw new NotFoundException(String.format("User ID %d not found.", id));
            }
        }
    }

    public List<User> get() throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS")) {
            List<User> userList = new ArrayList<>();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userList.add(createFromResult(rs));
            }

            return userList;
        }
    }

    public User get(int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return createFromResult(rs);
            }

            throw new NotFoundException(String.format("User ID %d not found.", id));
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }
}
