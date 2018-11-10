
package br.com.pizzaria.util;

/**
 *
 * @Eliezer
 */
public class ErroSistema extends Exception{

    public ErroSistema() {
    }

    public ErroSistema(String erro) {
        super("Sistema Pizzaria :"+erro);
    }

    public ErroSistema(String erro, Throwable causa) {
        super("Sistema Pizzaria :"+erro, causa);
    }
    
    
    
    
    
}
