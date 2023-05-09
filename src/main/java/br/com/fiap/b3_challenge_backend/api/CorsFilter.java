package br.com.fiap.b3_challenge_backend.api;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    /**
     * Cria o filtro para habilitar o CORS.
     *
     * @param requestContext  request context.
     * @param responseContext response context.
     * @throws IOException caso ocorra algum erro.
     * @see <a href="https://developer.mozilla.org/pt-BR/docs/Web/HTTP/CORS">CORS</a>
     * @see <a href="https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Controle_Acesso_CORS">Controle de acesso CORS</a>
     * @see <a href="https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Headers/Access-Control-Allow-Origin">Access-Control-Allow-Origin</a>
     */
    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add(
            "Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add(
            "Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().add(
            "Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization");
        responseContext.getHeaders().add(
            "Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
