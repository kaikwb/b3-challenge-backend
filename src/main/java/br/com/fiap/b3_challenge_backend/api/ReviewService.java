package br.com.fiap.b3_challenge_backend.api;

import br.com.fiap.b3_challenge_backend.beans.Review;
import br.com.fiap.b3_challenge_backend.dao.ReviewDAO;
import br.com.fiap.b3_challenge_backend.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/reviews")
public class ReviewService extends Service<Review> {

    /**
     * Cria um serviço para a entidade @see Review.
     *
     * @throws SQLException caso ocorra algum erro com a conexão de dados.
     */
    public ReviewService() throws SQLException {
        super(new ReviewDAO(DatabaseConnection.getConnection()));
    }
}
