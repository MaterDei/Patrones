/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author JAVIER
 */

@Stateless
@Path("/registrarVenta")
public class registrarVenta {
    
    @GET
    public String registrarVenta() {
        return "Venta registrada....";
    }
    
}
