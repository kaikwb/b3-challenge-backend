package br.com.fiap.b3_challenge_backend.api;

import br.com.fiap.b3_challenge_backend.beans.Video;
import br.com.fiap.b3_challenge_backend.dao.VideoDAO;
import br.com.fiap.b3_challenge_backend.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/videos")
public class VideoService extends Service<Video> {

    /**
     * Cria um serviço para a entidade @see Video.
     *
     * @throws SQLException caso ocorra algum erro com a conexão de dados.
     */
    public VideoService() throws SQLException {
        super(new VideoDAO(DatabaseConnection.getConnection()));
    }
}
