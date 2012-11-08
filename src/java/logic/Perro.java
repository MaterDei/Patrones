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
    }
    
    @Override
    protected  double obtenerPrecio(){
        try {
            return dp.consultarPrecios(Perro.class.getSimpleName());
        } catch (Exception ex) {
            Logger.getLogger(Perro.class.getName()).log(Level.SEVERE, null, ex);
            return -1000;
        }
    }
    
    @Override
    protected int obtenerExistencia(int solicitud){
    int pan=de.consultarExistencia(4);
    int salc= de.consultarExistencia(5);
    this.setReservas1(pan);
    this.setReservas2(salc);
    
    if(pan>=solicitud && salc>=solicitud)
    return 1;
    else return -1;
    }
    
}
