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

    public Service(DAO<T> entityDAO) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.entityDAO = entityDAO;
    }

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        try {
            return Response.status(200).entity(this.entityDAO.get()).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(T entity) {
        try {
            T entityCreated = this.entityDAO.create(entity);
            return Response.status(Response.Status.CREATED).entity(entityCreated).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, T entity) {
        try {
            this.entityDAO.update(id, entity);
            return Response.status(200).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        try {
            this.entityDAO.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }
}
