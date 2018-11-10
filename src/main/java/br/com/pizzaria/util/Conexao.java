package br.com.pizzaria.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @Eliezer
 */
public class Conexao {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public Conexao() {
    }

    public EntityManager getCon() throws ErroSistema {
        try {

            if (this.factory == null) {
                this.factory = Persistence
                        .createEntityManagerFactory("WS_PIZZARIA");
            }
            if (this.manager == null) {
                this.manager = this.factory.createEntityManager();
            }
            return this.manager;
        } catch (Exception e) {
            throw new ErroSistema("Não Conectou :", e);
        }
    }

    public void getClose() {
        if (this.manager.isOpen() == true) {
            this.manager.close();
        }
        if (this.factory.isOpen() == true) {
            this.factory.close();
        }
    }

}
