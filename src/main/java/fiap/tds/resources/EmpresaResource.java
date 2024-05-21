package fiap.tds.resources;

import fiap.tds.models.Empresa;
import fiap.tds.repositories.EmpresaRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("empresas")
public class EmpresaResource {
    private EmpresaRepository empresaRepository;

    public EmpresaResource() {
        this.empresaRepository = new EmpresaRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmpresasAll() {
        List<Empresa> empresasList = empresaRepository.getEmpresasAll();
        return Response.ok(empresasList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmpresaById(@PathParam("id") int id) {
        Empresa empresa = empresaRepository.getEmpresaById(id);
        if (empresa == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(empresa).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmpresa(Empresa empresa) {
        empresaRepository.createEmpresa(empresa);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmpresa(@PathParam("id") int id, Empresa empresa) {
        Empresa existingEmpresa = empresaRepository.getEmpresaById(id);
        if (existingEmpresa == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        empresaRepository.updateEmpresa(empresa, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmpresa(@PathParam("id") int id) {
        Empresa existingEmpresa = empresaRepository.getEmpresaById(id);
        if (existingEmpresa == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        empresaRepository.deleteEmpresa(id);
        return Response.ok().build();
    }

}
