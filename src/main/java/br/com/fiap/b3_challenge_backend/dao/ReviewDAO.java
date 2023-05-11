package br.com.fiap.b3_challenge_backend.dao;

import br.com.fiap.b3_challenge_backend.beans.Review;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReviewDAO extends DAO<Review> {
    static final String tableName = "REVIEWS";
    static final String idColumn = "ID";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("TITLE", "Title");
        put("AUTHOR", "Author");
        put("COMPANY", "Company");
        put("SOURCE", "Source");
        put("LINK", "Link");
        put("CREATED_AT", "CreatedAt");
        put("CONTENT", "Content");
    }};

    /**
     * Cria um DAO para a entidade Review.
     *
     * @param connection conexão com o banco de dados.
     */
    public ReviewDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Review.class);
    }
}
