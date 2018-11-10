package br.com.pizzaria.dao;

import br.com.pizzaria.model.PessoaModel;
import br.com.pizzaria.util.Conexao;
import br.com.pizzaria.util.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @Eliezer
 */
public class PessoaDAO {

    private  final EntityManager em;
    protected Conexao conecta;

    public PessoaDAO() throws ErroSistema {
        if (conecta == null) {
            this.conecta = new Conexao();
        }
        this.em = this.conecta.getCon();
    }

    public void salvar(PessoaModel p) throws ErroSistema {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new ErroSistema("(DAO)Não Salvou !", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public void deletar(Integer id) throws ErroSistema {
        try {
            PessoaModel p = this.em.find(PessoaModel.class, id);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new ErroSistema("(DAO)Não Deletou !", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public PessoaModel getId(Integer id) throws ErroSistema {
        try {
            return this.em.find(PessoaModel.class, id);
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca ID: ", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public PessoaModel getCpf(String cpf) throws ErroSistema {
        try {
            return (PessoaModel) this.em.createQuery("select p from PessoaModel p "
                    + "where p.cpf ='" + cpf + "'")
                    .getSingleResult();
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca cpf :", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public PessoaModel getRg(String rg) throws ErroSistema {
        try {
            return (PessoaModel) this.em.createQuery("select p from PessoaModel p "
                    + "where p.rg ='" + rg + "'")
                    .getSingleResult();
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca rg :", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public List<PessoaModel> getLista() throws ErroSistema {
        try {
            return this.em.createQuery("select p from PessoaModel p order by p.nome asc")
                    .getResultList();
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca lista :", e);
        } finally {
            this.conecta.getClose();
        }
    }

    public List<PessoaModel> getListaNomes(String nome) throws ErroSistema {
        try {
            return this.em.createQuery("select p from PessoaModel p where p.nome like '%" + nome + "%'")
                    .getResultList();
        } catch (Exception e) {
            throw new ErroSistema("(DAO)Erro busca lista nomes :", e);
        }finally{
            this.conecta.getClose();
        }
    }

}
