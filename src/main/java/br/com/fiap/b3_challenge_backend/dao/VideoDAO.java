package br.com.fiap.b3_challenge_backend.dao;

import br.com.fiap.b3_challenge_backend.beans.Video;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class VideoDAO extends DAO<Video> {
    static final String tableName = "VIDEOS";
    static final String idColumn = "ID";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("TITLE", "Title");
        put("AUTHOR", "Author");
        put("SOURCE", "Source");
        put("LINK", "Link");
        put("VIDEO_ID", "VideoId");
        put("THUMBNAIL", "Thumbnail");
        put("CREATED_AT", "CreatedAt");
    }};

    /**
     * Cria um DAO para a entidade @see Video.
     *
     * @param connection conexão com o banco de dados.
     */
    public VideoDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Video.class);
    }
}
