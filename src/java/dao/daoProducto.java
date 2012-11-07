/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import connection.Coneccion;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author JAVIER
 */
public class daoProducto {
    
    Connection con;
    
   
    
    public String consultarPrecios(String name) throws Exception{
        try{
            con = Coneccion.getConexion();
            System.out.print("adentro");

            String consulta = "SELECT nombreProducto, precio FROM producto WHERE nombreProducto = '" + name + "'";
	    java.sql.Statement sentencia = con.createStatement();
	    ResultSet rs = sentencia.executeQuery( consulta );

            if (rs.next()){
                return rs.getString("precio");
            }

            sentencia.close();
	    Coneccion.cerrarConexion();
            return "Consulta inválidasss";
        } catch(Exception ex){
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE,null,ex);
            return "Consulta inválida";
        }
    
    }
    
}
