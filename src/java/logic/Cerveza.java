/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.daoProducto;
import dao.daoExistencia;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVIER
 */
public class Cerveza extends Producto{
    
 
    daoProducto dp= new daoProducto();
    daoExistencia de= new daoExistencia();
    
    Cerveza(){
    this.setIdInsumo1(1);
    }
   
    @Override
    protected double obtenerPrecio(){
        try {
            return dp.consultarPrecios(Cerveza.class.getSimpleName());
        } catch (Exception ex) {
            Logger.getLogger(Cerveza.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    @Override
    protected int obtenerExistencia(int solicitud){
    int alch= de.consultarExistencia(this.getIdInsumo1());
    this.setReservas1(alch);
    if(alch>=solicitud)
        return 1;
    else
        return -1;
    }
    
    @Override
    protected int debitarExistencia(Producto prod, int cantidad){
        return de.debitarExistencia(prod, cantidad);
    }
    
}
