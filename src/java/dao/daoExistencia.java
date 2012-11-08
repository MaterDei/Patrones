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
import logic.Producto;

/**
 *
 * @author JAVIER
 */
public class daoExistencia {
    
        Connection con;

    
    
    public int consultarExistencia(int idInsumo){
        
        try{
            con = Coneccion.getConexion();

            String consulta = "SELECT cantidad FROM existencia WHERE idInsumo = '" + idInsumo + "'";
	    java.sql.Statement sentencia = con.createStatement();
	    ResultSet rs = sentencia.executeQuery( consulta );

            if (rs.next()){
                return rs.getInt("cantidad");
            }

            sentencia.close();
	    Coneccion.cerrarConexion();
            return -1;
        } catch(Exception ex){
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE,null,ex);
            return -1;
        }
        
       
     }
    
    
    public int debitarExistencia(Producto prod, int cantidad){
        
    try{
            con = Coneccion.getConexion();
            
            int nuevaCantidad= prod.getReservas1()-cantidad;
            int nuevaCantidad2= prod.getReservas2()-cantidad;
            
         //   UPDATE `borrachosbar`.`existencia` SET `cantidad`='103' WHERE `idInsumo`='1';

            String consulta = "UPDATE cantidad FROM existencia WHERE idInsumo = '" + cantidad + "'";
	    java.sql.Statement sentencia = con.createStatement();
	    ResultSet rs = sentencia.executeQuery( consulta );

            //if (rs.next()){
              //  return rs.getInt("cantidad");
           // }

            sentencia.close();
	    Coneccion.cerrarConexion();
            return -1;
        } catch(Exception ex){
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE,null,ex);
            return -1;
        }    
    
    }
   
    }
    
    
    
    
    
    
    
    
    

