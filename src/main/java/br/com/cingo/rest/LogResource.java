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
    private LogService logService = new LogService();

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
        logService.updateLog(id, log);
        return Response.ok(log).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLog(@PathParam("id") Long id) {
        logService.deleteLog(id);
        return Response.noContent().build();
    }
}
