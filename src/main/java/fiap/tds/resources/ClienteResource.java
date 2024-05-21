package fiap.tds.resources;

import fiap.tds.models.Cliente;
import fiap.tds.repositories.ClienteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("clientes")
public class ClienteResource {
    private ClienteRepository clienteRepository;

    public ClienteResource() {
        this.clienteRepository = new ClienteRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientesAll() {
        List<Cliente> clientesList = clienteRepository.getClientesAll();
        return Response.ok(clientesList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteById(@PathParam("id") int id) {
        Cliente cliente = clienteRepository.getClienteById(id);
        if (cliente == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente cliente) {
        clienteRepository.createCliente(cliente);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCliente(@PathParam("id") int id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.getClienteById(id);
        if (existingCliente == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteRepository.updateCliente(cliente, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCliente(@PathParam("id") int id) {
        Cliente existingCliente = clienteRepository.getClienteById(id);
        if (existingCliente == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteRepository.deleteCliente(id);
        return Response.ok().build();
    }

}
