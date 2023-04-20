package br.com.fiap.b3_challenge_backend.api;

import br.com.fiap.b3_challenge_backend.beans.Error;
import br.com.fiap.b3_challenge_backend.beans.ErrorCode;
import br.com.fiap.b3_challenge_backend.beans.User;
import br.com.fiap.b3_challenge_backend.dao.UserDAO;
import br.com.fiap.b3_challenge_backend.database.DatabaseConnection;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Path("/users")
public class UserService {
    @Context
    UriInfo uriInfo;

    private final Connection connection;
    private final UserDAO userDAO;

    public UserService() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.userDAO = new UserDAO(connection);
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
            return Response.status(200).entity(this.userDAO.get()).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        try {
            User user = this.userDAO.get(id);

            if (user == null) {
                throw new NotFoundException("User not found");
            }

            return Response.status(200).entity(user).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        try {
            User userCreated = this.userDAO.create(user);
            return Response.status(Response.Status.CREATED).entity(userCreated).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, User user) {
        try {
            user.setId(id);
            this.userDAO.update(id, user);
            return Response.status(200).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        try {
            this.userDAO.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return createResponseOnException(e);
        }
    }
}
