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
    
   
    
    public double consultarPrecios(String name) throws Exception{
        try{
            con = Coneccion.getConexion();
            System.out.print("adentro ");
            System.out.print(name);
            String consulta = "SELECT precio FROM producto WHERE nombreProducto = '" + name + "'";
	    java.sql.Statement sentencia = con.createStatement();
	    ResultSet rs = sentencia.executeQuery( consulta );

            if (rs.next()){
                System.out.print(rs.getDouble("precio"));
                return rs.getDouble("precio");
            }

            sentencia.close();
	    Coneccion.cerrarConexion();
            return -1;
        } catch(Exception ex){
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE,null,ex);
            return -1;
        }
    
    }
    
}
