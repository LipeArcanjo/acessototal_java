package fiap.tds.resources;

import fiap.tds.models.Midia;
import fiap.tds.repositories.MidiaRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("midias")
public class MidiaResource {
    private MidiaRepository midiaRepository;

    public MidiaResource() {
        this.midiaRepository = new MidiaRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMidiasAll() {
        List<Midia> midiasList = midiaRepository.getMidiasAll();
        return Response.ok(midiasList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMidiaById(@PathParam("id") int id) {
        Midia midia = midiaRepository.getMidiaById(id);
        if (midia == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(midia).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMidia(Midia midia) {
        midiaRepository.createMidia(midia);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMidia(@PathParam("id") int id, Midia midia) {
        Midia existingMidia = midiaRepository.getMidiaById(id);
        if (existingMidia == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        midiaRepository.updateMidia(midia, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMidia(@PathParam("id") int id) {
        Midia existingMidia = midiaRepository.getMidiaById(id);
        if (existingMidia == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        midiaRepository.deleteMidia(id);
        return Response.ok().build();
    }

}
