
package br.com.pizzaria.control.ws;

import br.com.pizzaria.dao.Item_PedidoDAO;
import br.com.pizzaria.model.Item_PedidoModel;
import br.com.pizzaria.util.ErroSistema;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @Eliezer
 */
@Path("/item")
public class Item_PedidoControl {
    private Item_PedidoDAO dao;

    public Item_PedidoControl() throws ErroSistema {
        if (this.dao == null){
            this.dao = new Item_PedidoDAO();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista/json")
    public List<Item_PedidoModel> getListaJason(){
        try {
            return this.dao.getLista();
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro GET lista :"+e.getMessage())
                    .build());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}/json")
    public Item_PedidoModel getId(@PathParam("id") Integer id){
        try {
            if (id < 0){
                throw new WebApplicationException(Response
                        .status(404)
                        .entity("Parametro não encontrado !")
                        .build());
            }
            return dao.getId(id);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro GET busca ID :"+e.getMessage())
                    .build());
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pedido/id/{id}/json")
    public List<Item_PedidoModel> getItemsPedido(@PathParam("id") Integer id){
        try {
            if (id < 0){
                throw new WebApplicationException(Response
                        .status(404)
                        .entity("Parametro não encontrado !")
                        .build());
            }
            return dao.getItensPedido(id);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro GET busca id pedido :"+e.getMessage())
                    .build());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listaDescricao") //http://localhost:8080/WS/v1/item/listaDescricao?descricao=fanta
    public List<Item_PedidoModel> listaDescricao(@QueryParam("descricao") String descricao){
        try {
            if (descricao.length() < 0){
                throw new WebApplicationException(Response
                        .status(404)
                        .entity("Paramentro não corresponde ao solicitado !")
                        .build());
            }
            return dao.getItensDescricao(descricao);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro GET busca descricão :"+e.getMessage())
                    .build());
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Item_PedidoModel i){
        try {
            this.dao.salvar(i);
            return Response.status(200).entity("Salvo com sucesso !").build();
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro POST :"+e.getMessage())
                    .build());
        }        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Item_PedidoModel i){
        try {
            this.dao.salvar(i);
            return Response.status(200).entity("Salvo com sucesso !").build();
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro PUT :"+e.getMessage())
                    .build());
        }        
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id){
        try {
            Item_PedidoModel i = this.dao.getId(id);
            if (i == null){
                throw new WebApplicationException(Response
                        .status(404)
                        .entity("Cadastro não encontrado para ser deletado !")
                        .build());
            }
            this.dao.deletar(id);
            return Response.status(200).entity("Deletado com sucesso !").build();
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro DELETE :"+e.getMessage())
                    .build());
        }
    }
    
    
    
}
