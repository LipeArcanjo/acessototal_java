package fiap.tds.resources;

import fiap.tds.models.Pagina;
import fiap.tds.repositories.PaginaRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("paginas")
public class PaginaResource {
    private PaginaRepository paginaRepository;

    public PaginaResource() {
        this.paginaRepository = new PaginaRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaginasAll() {
        List<Pagina> paginasList = paginaRepository.getPaginasAll();
        return Response.ok(paginasList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaginaById(@PathParam("id") int id) {
        Pagina pagina = paginaRepository.getPaginaById(id);
        if (pagina == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pagina).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPagina(Pagina pagina) {
        paginaRepository.createPagina(pagina);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePagina(@PathParam("id") int id, Pagina pagina) {
        Pagina existingPagina = paginaRepository.getPaginaById(id);
        if (existingPagina == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        paginaRepository.updatePagina(pagina, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePagina(@PathParam("id") int id) {
        Pagina existingPagina = paginaRepository.getPaginaById(id);
        if (existingPagina == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        paginaRepository.deletePagina(id);
        return Response.ok().build();
    }

}
