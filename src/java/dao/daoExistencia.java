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
import logic.Cerveza;
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
            int can=-1;
            String consulta = "SELECT cantidad FROM existencia WHERE idInsumo = '" + idInsumo + "'";
	    java.sql.Statement sentencia = con.createStatement();
	    ResultSet rs = sentencia.executeQuery( consulta );

            if (rs.next()){
                can= rs.getInt("cantidad");
            }

            sentencia.close();
	    Coneccion.cerrarConexion();
            return can;
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
            int id=prod.getIdInsumo1();
            int rs=999;
            String consulta;
            
            consulta = "UPDATE existencia SET cantidad ='" + nuevaCantidad + "'WHERE idInsumo = '" + id+ "'";
	    java.sql.Statement sentencia = con.createStatement();
	    rs = sentencia.executeUpdate( consulta );

            if(prod instanceof Cerveza)
            {
            sentencia.close();
	    Coneccion.cerrarConexion();
            }
            
            else{
                id=prod.getIdInsumo2();
                consulta = "UPDATE existencia SET cantidad ='" + nuevaCantidad2 + "'WHERE idInsumo = '" + id+ "'";
                java.sql.Statement sentencias = con.createStatement();
                rs = sentencias.executeUpdate( consulta );
                sentencia.close();
                Coneccion.cerrarConexion();
            }
            
            
            if(rs==1){
                System.out.print("Cantidad debitada exitosamente");
                return 1;}
            else 
                return -1;
        } catch(Exception ex){
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE,null,ex);
            return -1;
        }    
    
    }
   
    }
    
    
    
    
    
    
    
    
    

