package fiap.tds.resources;

import fiap.tds.models.Industria;
import fiap.tds.repositories.IndustriaRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("industrias")
public class IndustriaResource {
    private IndustriaRepository industriaRepository;

    public IndustriaResource() {
        this.industriaRepository = new IndustriaRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIndustriasAll() {
        List<Industria> industriasList = industriaRepository.getIndustriasAll();
        return Response.ok(industriasList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIndustriaById(@PathParam("id") int id) {
        Industria industria = industriaRepository.getIndustriaById(id);
        if (industria == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(industria).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createIndustria(Industria industria) {
        industriaRepository.createIndustria(industria);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIndustria(@PathParam("id") int id, Industria industria) {
        Industria existingIndustria = industriaRepository.getIndustriaById(id);
        if (existingIndustria == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        industriaRepository.updateIndustria(industria, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteIndustria(@PathParam("id") int id) {
        Industria existingIndustria = industriaRepository.getIndustriaById(id);
        if (existingIndustria == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        industriaRepository.deleteIndustria(id);
        return Response.ok().build();
    }

}
