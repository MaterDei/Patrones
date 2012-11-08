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
public class Perro extends Producto{
    
    
    daoProducto dp= new daoProducto();
    daoExistencia de= new daoExistencia();
    
    Perro(){
        this.setIdInsumo1(4);
        this.setIdInsumo2(5);
    }
    
    
    @Override
    protected  double obtenerPrecio(){
        try {
            String name=Perro.class.getSimpleName();
            return dp.consultarPrecios(name);
        } catch (Exception ex) {
            Logger.getLogger(Perro.class.getName()).log(Level.SEVERE, null, ex);
            return -1000;
        }
    }
    
    @Override
    protected int obtenerExistencia(int solicitud){
    int pan=de.consultarExistencia(this.getIdInsumo1());
    int salc= de.consultarExistencia(this.getIdInsumo2());
    this.setReservas1(pan);
    this.setReservas2(salc);
    
    if(pan>=solicitud && salc>=solicitud)
    return 1;
    else return -1;
    }
    
    @Override
    protected int debitarExistencia(Producto prod, int cantidad){
    return de.debitarExistencia(prod, cantidad);
    }
    
}
