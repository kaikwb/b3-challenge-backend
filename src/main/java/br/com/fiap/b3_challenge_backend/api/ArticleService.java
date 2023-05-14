package br.com.fiap.b3_challenge_backend.api;

import br.com.fiap.b3_challenge_backend.beans.Article;
import br.com.fiap.b3_challenge_backend.dao.ArticleDAO;
import br.com.fiap.b3_challenge_backend.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/articles")
public class ArticleService extends Service<Article> {

    /**
     * Cria um serviço para a entidade @see Article.
     *
     * @throws SQLException caso ocorra algum erro com a conexão de dados.
     */
    public ArticleService() throws SQLException {
        super(new ArticleDAO(DatabaseConnection.getConnection()));
    }
}
