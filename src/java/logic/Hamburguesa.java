/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.daoExistencia;
import dao.daoProducto;
import dao.daoProveedor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVIER
 */
public class Hamburguesa extends Producto{
    
    daoProducto dp= new daoProducto();
    daoExistencia de = new daoExistencia();
    daoProveedor dpr= new daoProveedor();
    
    public Hamburguesa(){
        
        this.setIdInsumo1(2);
        this.setIdInsumo2(3);
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
    int panH=de.consultarExistencia(this.getIdInsumo1());
    int carne=de.consultarExistencia(this.getIdInsumo2());
    
    System.out.print(carne);
               
    this.setReservas1(panH);
    this.setReservas2(carne);
    
    if(carne>=solicitud && panH>=solicitud)
        return 1;
    else
        return -1;
    }
    
    @Override
    protected int debitarExistencia(Producto prod, int cantidad){
    return de.debitarExistencia(prod, cantidad);
    }
    
    @Override
    protected  String [] getProveedorUrgente(int id){
        try {
            return dpr.getProveedorUrgente(id);
        } catch (Exception ex) {
            Logger.getLogger(Hamburguesa.class.getName()).log(Level.SEVERE, null, ex);
            return new String[] {"No se pudo realizar la llamada para obtener datos del proveedor urgente"};
        }
    }
    
}
