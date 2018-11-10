package br.com.pizzaria.control.ws;

import br.com.pizzaria.dao.PedidoDAO;
import br.com.pizzaria.model.PedidoModel;
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
@Path("/pedido")
public class PedidoControl {

    private PedidoDAO dao;

    public PedidoControl() throws ErroSistema {
        if (this.dao == null) {
            this.dao = new PedidoDAO();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista/json")
    public List<PedidoModel> getListaJson() {
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
    public PedidoModel getId(@PathParam("id") Integer id) {
        try {
            if (id < 0) {
                throw new WebApplicationException(Response
                        .status(404).entity("Parametro não encontrado !").build());
            }
            return this.dao.getId(id);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500).entity("Erro GET ID :" + e.getMessage()).build());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cliente/cpf/{cpf}/json")
    public List<PedidoModel> getCpfCliente(@PathParam("cpf") String cpf){
        try {
            if (cpf.length() != 14){
                throw new WebApplicationException(Response
                        .status(404)
                        .entity("Paramentro não corresponde ao solicitado !")
                        .build());
            }
            return this.dao.getCpfCliente(cpf);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro GET cpf cliente :"+e.getMessage())
                    .build());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/entregador/cpf/{cpf}/json")
    public List<PedidoModel> getCpfEntregador(@PathParam("cpf") String cpf){
        try {
            if (cpf.length() != 14){
                throw new WebApplicationException(Response
                        .status(404)
                        .entity("Paramentro não corresponde ao solicitado !")
                        .build());
            }
            return this.dao.getCpfEntregador(cpf);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                    .entity("Erro GET cpf cliente :"+e.getMessage())
                    .build());
        }        
    } 
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(PedidoModel p){
        try {
            this.dao.salvar(p);
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
    public Response update(PedidoModel p){
        try {
            this.dao.salvar(p);
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
            PedidoModel p = this.dao.getId(id);
            if (p == null){
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
