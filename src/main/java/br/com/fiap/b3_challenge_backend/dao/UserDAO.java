package br.com.fiap.b3_challenge_backend.dao;

import br.com.fiap.b3_challenge_backend.beans.User;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDAO extends DAO<User> {
    static final String tableName = "USERS";
    static final String idColumn = "ID";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("FIRST_NAME", "FirstName");
        put("LAST_NAME", "LastName");
        put("MAIL", "Mail");
        put("PASSWORD", "Password");
        put("POSTAL_CODE", "PostalCode");
        put("ADDRESS", "Address");
        put("ADDRESS_NUMBER", "AddressNumber");
        put("ADDRESS2", "Address2");
        put("NEIGHBORHOOD", "Neighborhood");
        put("CITY", "City");
        put("STATE", "State");
    }};

    public UserDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, User.class);
    }
}
