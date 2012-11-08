/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.daoExistencia;
import dao.daoProducto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVIER
 */
public class Hamburguesa extends Producto{
    
    
    
    daoProducto dp= new daoProducto();
    daoExistencia de = new daoExistencia();
    
    public Hamburguesa(){
        
    
    }
    
 
    
   
    @Override
    protected double obtenerPrecio(){
        try {
            String name= Hamburguesa.class.getSimpleName();
        return (dp.consultarPrecios(name));
        } catch (Exception ex) {
            Logger.getLogger(Hamburguesa.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    
    }
    
    @Override
    protected int obtenerExistencia(int solicitud){
    int panH=de.consultarExistencia(2);
    int carne=de.consultarExistencia(3);
    
    this.setReservas1(panH);
    this.setReservas2(carne);
    
    if(carne>=solicitud && panH>=solicitud)
        return 1;
    else
        return -1;
    }
    
}
