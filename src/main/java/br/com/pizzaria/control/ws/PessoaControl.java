package br.com.pizzaria.control.ws;

import br.com.pizzaria.dao.PessoaDAO;
import br.com.pizzaria.model.PessoaModel;
import br.com.pizzaria.util.ErroSistema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("/pessoa")
public class PessoaControl {

    private PessoaDAO dao;

    public PessoaControl() throws ErroSistema {
        if (this.dao == null) {
            this.dao = new PessoaDAO();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/teste")
    public String getTeste() {
        return "Está Ok com meu Serviço";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista/json")
    public List<PessoaModel> getListaJson(){
        try {
            return this.dao.getLista();
        } catch (ErroSistema ex) {
            throw new WebApplicationException(Response
                 .status(500).entity("(GET)Erro ao lista :"+ex.getMessage())
                    .build());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}/json") //http://localhost:8080/WS/v1/pessoa/id/nr ID/json
    public PessoaModel getId(@PathParam("id") Integer id){
        try {
            if (id < 0){
                throw new WebApplicationException(Response
                .status(404)
                        .entity("Parametro não encontrado !").build());
            }           
            return this.dao.getId(id);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                      .entity("Erro GET ID :"+e.getMessage()).build());
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cpf/{cpf}/json") //http://localhost:8080/WS/v1/pessoa/cpf/nr CPF/json
    public PessoaModel getCpf(@PathParam("cpf") String cpf){
        try {
            if(cpf.length() <= -1){
                throw new WebApplicationException(Response
                    .status(404)
                        .entity("Paramento não encontrado !")
                            .build());
            }
            return this.dao.getCpf(cpf);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                    .status(500)
                        .entity("Erro GET CPF :"+e.getMessage())
                            .build());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rg/{rg}/json") //http://localhost:8080/WS/v1/pessoa/rg/nr RG/json
    public PessoaModel getRg(@PathParam("rg") String rg){
        try {
            if(rg.length()<= -1){
                throw new WebApplicationException(Response
                        .status(404)
                            .entity("Parametro não encontrado !")
                                .build());
            }
            return this.dao.getRg(rg);
        } catch (ErroSistema e) {
            throw new WebApplicationException(Response
                        .status(500)
                            .entity("Erro GET RG :"+e.getMessage())
                                .build());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listaNome") //http://localhost:8080/WS/v1/pessoa/listaNome?nome=miranda
    public List<PessoaModel> getListaNome(@QueryParam("nome") String nome){
        try {
            if (nome.length() <= -1){
                throw new WebApplicationException(Response
                            .status(404)
                                .entity("Parametro não encontrado !")
                                    .build());
            }
            return this.dao.getListaNomes(nome);
        } catch (Exception e) {
            throw new WebApplicationException(Response
                        .status(500)
                            .entity("Erro GET NOMES :"+e.getMessage())
                                .build());
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(PessoaModel p){
        try {
            this.dao.salvar(p);
            return Response.status(200).entity("Cadastrado com sucesso !").build();
        } catch (Exception e) {
            throw new WebApplicationException(Response
                    .status(500)
                        .entity("Erro POST :"+e.getMessage())
                            .build());
        }
        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(PessoaModel p){
        try {
            this.dao.salvar(p);
            return Response.status(200).entity("Salvo com sucesso !").build();
        } catch (Exception e) {
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
            PessoaModel p = this.dao.getId(id);
            if (p == null){
                throw new WebApplicationException(Response
                            .status(404)
                                .entity("Cadastro não encontrado para ser deletado !")
                                    .build());
            }
            this.dao.deletar(id);
            return Response.status(200).entity("Deletado com sucesso !").build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(500)
                        .entity("Erro DELETAR :"+e.getMessage())
                            .build());
        }
    }
    
    
    
    
    

}
