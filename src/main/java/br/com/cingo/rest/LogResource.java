package cingo.rest;

import cingo.model.Log;
import cingo.service.LogService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogResource {
    private final LogService logService = new LogService();

    @GET
    public Response listLog() {
        List<Log> logs = logService.listLog();
        return Response.ok(logs).build();
    }

    @POST
    public Response saveLog(Log log) {
        logService.saveLog(log);
        return Response.status(Response.Status.CREATED).entity(log).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateLog(@PathParam("id") Long id, Log log) {
        Log existente = logService.updateLog(id, log);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Log não encontrado").build();
        }
        return Response.ok(existente).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLog(@PathParam("id") Long id) {
        logService.deleteLog(id);
        return Response.noContent().build();
    }

    @OPTIONS
    @Path("/logs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response corsPreflight() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .build();
    }

    @GET
    @Path("/teste")
    public Response teste() {
        return Response.ok("Funcionando!").build();
    }

}
