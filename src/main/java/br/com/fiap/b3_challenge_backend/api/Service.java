package br.com.fiap.b3_challenge_backend.api;

import br.com.fiap.b3_challenge_backend.beans.Error;
import br.com.fiap.b3_challenge_backend.beans.ErrorCode;
import br.com.fiap.b3_challenge_backend.dao.DAO;
import br.com.fiap.b3_challenge_backend.database.DatabaseConnection;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Service<T> {
    @Context
    UriInfo uriInfo;

    public final Connection connection;
    private final DAO<T> entityDAO;

    /**
     * Cria um serviço para a entidade T.
     *
     * @param entityDAO DAO da entidade T.
     * @throws SQLException caso ocorra algum erro com a conexão de dados.
     */
    public Service(DAO<T> entityDAO) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.entityDAO = entityDAO;
    }

    /**
     * Cria uma resposta HTTP de acordo com a exceção.
     *
     * @param e exceção lançada.
     * @return resposta HTTP.
     */
    public Response createResponseOnException(Exception e) {
        Object exceptionClass = e.getClass();
        String exceptionMessage = e.getMessage();

        if (exceptionClass == NotFoundException.class) {
            Error error = new Error(ErrorCode.NOT_FOUND, exceptionMessage);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        } else if (exceptionClass == SQLIntegrityConstraintViolationException.class) {
            Error error = new Error(ErrorCode.INVALID_VALUE, exceptionMessage);
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        } else if (exceptionClass == SQLException.class) {
            Error error = new Error(ErrorCode.UNKNOWN_ERROR_DATABASE, exceptionMessage);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        } else {
            Error error = new Error(ErrorCode.UNKNOWN_ERROR, exceptionMessage);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        }
    }

    /**
     * Retorna todas as entidades T.
     *
     * @return resposta HTTP.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntities() {
        try {
            return Response.status(200).entity(this.entityDAO.get()).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    /**
     * Retorna uma entidade T.
     *
     * @param id identificador da entidade.
     * @return resposta HTTP.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntity(@PathParam("id") int id) {
        try {
            T entity = this.entityDAO.get(id);

            if (entity == null) {
                throw new NotFoundException("User not found");
            }

            return Response.status(200).entity(entity).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    /**
     * Cria uma entidade T.
     *
     * @param entity entidade T.
     * @return resposta HTTP.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEntity(T entity) {
        try {
            T entityCreated = this.entityDAO.create(entity);
            return Response.status(Response.Status.CREATED).entity(entityCreated).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    /**
     * Atualiza uma entidade T.
     *
     * @param id     identificador da entidade.
     * @param entity entidade T.
     * @return resposta HTTP.
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEntity(@PathParam("id") int id, T entity) {
        try {
            this.entityDAO.update(id, entity);
            return Response.status(200).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    /**
     * Deleta uma entidade T.
     *
     * @param id identificador da entidade.
     * @return resposta HTTP.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteEntity(@PathParam("id") int id) {
        try {
            this.entityDAO.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }
}
