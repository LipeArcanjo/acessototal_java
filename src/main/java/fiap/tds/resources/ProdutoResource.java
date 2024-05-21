package fiap.tds.resources;

import fiap.tds.models.Produto;
import fiap.tds.repositories.ProdutoRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("produtos")
public class ProdutoResource {
    private ProdutoRepository produtoRepository;

    public ProdutoResource() {
        this.produtoRepository = new ProdutoRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProdutosAll() {
        List<Produto> produtosList = produtoRepository.getProdutosAll();
        return Response.ok(produtosList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProdutoById(@PathParam("id") int id) {
        Produto produto = produtoRepository.getProdutoById(id);
        if (produto == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduto(Produto produto) {
        produtoRepository.createProduto(produto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduto(@PathParam("id") int id, Produto produto) {
        Produto existingProduto = produtoRepository.getProdutoById(id);
        if (existingProduto == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoRepository.updateProduto(produto, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduto(@PathParam("id") int id) {
        Produto existingProduto = produtoRepository.getProdutoById(id);
        if (existingProduto == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoRepository.deleteProduto(id);
        return Response.ok().build();
    }

}
