package cingo.rest;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class CORSFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String ORIGIN = "Origin";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String origin = requestContext.getHeaderString(ORIGIN);
        if (origin != null) {
            requestContext.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            requestContext.getHeaders().add(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE");
            requestContext.getHeaders().add(ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Accept, Authorization, Origin, X-Requested-With, Access-Control-Allow-Origin");
            requestContext.getHeaders().add(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String origin = requestContext.getHeaderString(ORIGIN);
        if (origin != null) {
            responseContext.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            responseContext.getHeaders().add(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE");
            responseContext.getHeaders().add(ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Accept, Authorization, Origin, X-Requested-With, Access-Control-Allow-Origin");
            responseContext.getHeaders().add(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        }
    }
}
