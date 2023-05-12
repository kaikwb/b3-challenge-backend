package br.com.fiap.b3_challenge_backend.dao;

import br.com.fiap.b3_challenge_backend.beans.Text;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class TextDAO extends DAO<Text> {
    static final String tableName = "TEXTS";
    static final String idColumn = "ID";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("TITLE", "Title");
        put("AUTHOR", "Author");
        put("SOURCE", "Source");
        put("LINK", "Link");
        put("CREATED_AT", "CreatedAt");
        put("CONTENT", "Content");
    }};

    /**
     * Cria um DAO para a entidade Text.
     *
     * @param connection conexão com o banco de dados.
     */
    public TextDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Text.class);
    }
}
