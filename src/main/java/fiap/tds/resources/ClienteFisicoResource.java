package fiap.tds.resources;

import fiap.tds.models.ClienteFisico;
import fiap.tds.repositories.ClienteFisicoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("clientefisico")
public class ClienteFisicoResource {
    private ClienteFisicoRepository clienteFisicoRepository;

    public ClienteFisicoResource() {
        this.clienteFisicoRepository = new ClienteFisicoRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientesFisicosAll() {
        List<ClienteFisico> clientesFisicosList = clienteFisicoRepository.getClientesFisicosAll();
        return Response.ok(clientesFisicosList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteFisicoById(@PathParam("id") int id) {
        ClienteFisico clienteFisico = clienteFisicoRepository.getClienteFisicoById(id);
        if (clienteFisico == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(clienteFisico).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClienteFisico(ClienteFisico clienteFisico) {
        clienteFisicoRepository.createClienteFisico(clienteFisico);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClienteFisico(@PathParam("id") int id, ClienteFisico clienteFisico) {
        ClienteFisico existingClienteFisico = clienteFisicoRepository.getClienteFisicoById(id);
        if (existingClienteFisico == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteFisicoRepository.updateClienteFisico(clienteFisico, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClienteFisico(@PathParam("id") int id) {
        ClienteFisico existingClienteFisico = clienteFisicoRepository.getClienteFisicoById(id);
        if (existingClienteFisico == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteFisicoRepository.deleteClienteFisico(id);
        return Response.ok().build();
    }

}
