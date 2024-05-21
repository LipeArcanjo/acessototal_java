package fiap.tds.resources;

import fiap.tds.models.ClienteJuridico;
import fiap.tds.repositories.ClienteJuridicoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("clientesjuridicos")
public class ClienteJuridicoResource {
    private ClienteJuridicoRepository clienteJuridicoRepository;

    public ClienteJuridicoResource() {
        this.clienteJuridicoRepository = new ClienteJuridicoRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientesJuridicosAll() {
        List<ClienteJuridico> clientesJuridicosList = clienteJuridicoRepository.getClientesJuridicosAll();
        return Response.ok(clientesJuridicosList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteJuridicoById(@PathParam("id") int id) {
        ClienteJuridico clienteJuridico = clienteJuridicoRepository.getClienteJuridicoById(id);
        if (clienteJuridico == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(clienteJuridico).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClienteJuridico(ClienteJuridico clienteJuridico) {
        clienteJuridicoRepository.createClienteJuridico(clienteJuridico);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClienteJuridico(@PathParam("id") int id, ClienteJuridico clienteJuridico) {
        ClienteJuridico existingClienteJuridico = clienteJuridicoRepository.getClienteJuridicoById(id);
        if (existingClienteJuridico == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteJuridicoRepository.updateClienteJuridico(clienteJuridico, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClienteJuridico(@PathParam("id") int id) {
        ClienteJuridico existingClienteJuridico = clienteJuridicoRepository.getClienteJuridicoById(id);
        if (existingClienteJuridico == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteJuridicoRepository.deleteClienteJuridico(id);
        return Response.ok().build();
    }

}
