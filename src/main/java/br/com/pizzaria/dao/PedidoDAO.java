package br.com.pizzaria.dao;

import br.com.pizzaria.model.Item_PedidoModel;
import br.com.pizzaria.model.PedidoModel;
import br.com.pizzaria.util.Conexao;
import br.com.pizzaria.util.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @Eliezer
 */
public class PedidoDAO {

    private final EntityManager em;
    private Conexao conecta;

    public PedidoDAO() throws ErroSistema {
        if (this.conecta == null) {
            this.conecta = new Conexao();
        }
        this.em = this.conecta.getCon();
    }

    public void salvar(PedidoModel p) throws ErroSistema {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ErroSistema("(DAO)Não salvou !", e);
        } finally {
            conecta.getClose();
        }
    }

    public void deletar(Integer id) throws ErroSistema {
        try {
            PedidoModel p = em.find(PedidoModel.class, id);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ErroSistema("(DAO)Não deletou !", e);
        } finally {
            conecta.getClose();
        }
    }

    public PedidoModel getId(Integer id) throws ErroSistema {
        try {
//        List<Item_PedidoModel> items = em.createQuery("select i from Item_PedidoModel i "
//                + "INNER JOIN i.pedido_id p "
//                + "where p.id =" + id).getResultList();
            List<Item_PedidoModel> items = em.createQuery("select i from Item_PedidoModel i "
                    + "where i.pedido_id =" + id).getResultList();
            PedidoModel p = em.find(PedidoModel.class, id);
            p.setListaItens(items);
            return p;
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca ID :", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public List<PedidoModel> getCpfCliente(String cpf) throws ErroSistema {
        try {
            List<PedidoModel> lista = em.createQuery("select p from PedidoModel p "
                    + "INNER JOIN p.cliente_id c "
                    + "where c.cpf ='" + cpf + "'").getResultList();
            for (PedidoModel p : lista) {
                List<Item_PedidoModel> items = em.createQuery("select i from Item_PedidoModel i "
                        + "where i.pedido_id=" + p.getId()).getResultList();
                p.setListaItens(items);
            }
            return lista;
        } catch (Exception e) {
            throw new ErroSistema("()Erro busca cpf Cliente :", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public List<PedidoModel> getCpfEntregador(String cpf) throws ErroSistema {
        try {
            List<PedidoModel> lista = em.createQuery("select p from PedidoModel p "
                    + "INNER JOIN p.entregador_id e "
                    + "where e.cpf = '" + cpf + "'").getResultList();
            for (PedidoModel p : lista) {
                List<Item_PedidoModel> items = em.createQuery("select i from Item_PedidoModel i "
                        + "where i.pedido_id =" + p.getId()).getResultList();
                p.setListaItens(items);
            }
            return lista;
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca cpf Entregador :", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public List<PedidoModel> getLista() throws ErroSistema {
        try {
            List<PedidoModel> lista = this.em.createQuery("select p from PedidoModel p ").getResultList();
            //***Entra em loop..pedido dos items e items do pedido
            for (PedidoModel p : lista) {
//            List<Item_PedidoModel> items = em.createQuery("select i from Item_PedidoModel i "
//                    + "INNER JOIN i.pedido_id p "
//                    + "where p.id =" + p.getId()).getResultList();            
//            for (Item_PedidoModel e : items) {
//                e.setPedido_id(null);
//            }   

                List<Item_PedidoModel> items = em.createQuery("select i from Item_PedidoModel i "
                        + "where i.pedido_id =" + p.getId()).getResultList();
                p.setListaItens(items);
            }
            return lista;
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca lista :", e);
        } finally {
            this.conecta.getClose();
        }
    }

}
