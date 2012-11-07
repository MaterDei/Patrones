/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import logic.Tarifar;
/**
 *
 * @author JAVIER
 */
@Stateless
@Path("/Facturar")
public class Facturar {

    @GET
    public String Facturar(@QueryParam("codigoFactura") String codigoFactura, @QueryParam("productos") String productos) throws Exception {

        Tarifar calculo= new Tarifar();
        return calculo.calcular(codigoFactura, productos);

         
    }
}
