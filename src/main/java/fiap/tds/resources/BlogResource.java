package fiap.tds.resources;

import fiap.tds.models.Blog;
import fiap.tds.repositories.BlogRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("blogs")
public class BlogResource {
    private BlogRepository blogRepository;

    public BlogResource() {
        this.blogRepository = new BlogRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlogsAll() {
        List<Blog> blogsList = blogRepository.getBlogsAll();
        return Response.ok(blogsList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlogById(@PathParam("id") int id) {
        Blog blog = blogRepository.getBlogById(id);
        if (blog == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(blog).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBlog(Blog blog) {
        blogRepository.createBlog(blog);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBlog(@PathParam("id") int id, Blog blog) {
        Blog existingBlog = blogRepository.getBlogById(id);
        if (existingBlog == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        blogRepository.updateBlog(blog, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBlog(@PathParam("id") int id) {
        Blog existingBlog = blogRepository.getBlogById(id);
        if (existingBlog == null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        blogRepository.deleteBlog(id);
        return Response.ok().build();
    }

}
