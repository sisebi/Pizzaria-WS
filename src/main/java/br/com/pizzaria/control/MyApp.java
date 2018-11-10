
package br.com.pizzaria.control;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @Eliezer
 */
@ApplicationPath("v1")
public class MyApp extends ResourceConfig{

    public MyApp() {
        packages("CONTROL.WS");
    }

    
}
