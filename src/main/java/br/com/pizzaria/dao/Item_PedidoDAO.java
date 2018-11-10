package br.com.pizzaria.dao;

import br.com.pizzaria.model.Item_PedidoModel;
import br.com.pizzaria.util.Conexao;
import br.com.pizzaria.util.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @Eliezer
 */
public class Item_PedidoDAO {

    private final EntityManager em;
    private Conexao conectar;

    public Item_PedidoDAO() throws ErroSistema {
        if (this.conectar == null) {
            this.conectar = new Conexao();
        }
        this.em = conectar.getCon();
    }

    public void salvar(Item_PedidoModel i) throws ErroSistema {
        try {
            em.getTransaction().begin();
            em.merge(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ErroSistema("(DAO)Não salvou !", e);
        } finally {
            this.conectar.getClose();
        }
    }

    public void deletar(Integer id) throws ErroSistema {
        try {
            Item_PedidoModel i = em.find(Item_PedidoModel.class, id);
            em.getTransaction().begin();
            em.remove(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ErroSistema("(DAO)Não deletou !", e);
        } finally {
            this.conectar.getClose();
        }
    }

    public Item_PedidoModel getId(Integer id) throws ErroSistema {
        try {
            return em.find(Item_PedidoModel.class, id);
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca ID :", e);
        }finally{
            this.conectar.getClose();
        }
    }
    
    public List<Item_PedidoModel> getLista() throws ErroSistema{
        try {
            return em.createQuery("select i from Item_PedidoModel i order by i.descricao asc").getResultList();
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca lista :", e);
        }finally{
            this.conectar.getClose();
        }
    }
    
    public List<Item_PedidoModel> getItensPedido(Integer id) throws ErroSistema{
        try {
            return  em.createQuery("select i from Item_PedidoModel i "
                    + "where i.pedido_id ="+id).getResultList();
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca items Pedido lista :", e);
        }finally{
            this.conectar.getClose();
        }
    }
    
    public List<Item_PedidoModel> getItensDescricao(String descricao) throws ErroSistema{
        try {
            return em.createQuery("select i from Item_PedidoModel i "
                    + "where i.descricao like '%"+descricao+"%'").getResultList();
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca itens Descição lista :", e);
        }finally{
            this.conectar.getClose();
        }        
    }
        

}
