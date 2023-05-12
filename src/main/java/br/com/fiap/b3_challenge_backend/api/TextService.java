package br.com.fiap.b3_challenge_backend.api;

import br.com.fiap.b3_challenge_backend.beans.Text;
import br.com.fiap.b3_challenge_backend.dao.TextDAO;
import br.com.fiap.b3_challenge_backend.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/texts")
public class TextService extends Service<Text> {

    /**
     * Cria um serviço para a entidade @see Text.
     *
     * @throws SQLException caso ocorra algum erro com a conexão de dados.
     */
    public TextService() throws SQLException {
        super(new TextDAO(DatabaseConnection.getConnection()));
    }
}
