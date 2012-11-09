/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author JAVIER
 */
public abstract class Producto {
    
    private String nombre;
    private int cantidad;
    private int reservas1;
    private int reservas2;
    
    private int idInsumo1;
    private int idInsumo2;
    
    
   
    public String getNombre() {
		return nombre;
	}
    
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
    public int getCantidad() {
		return cantidad;
	}
    
    public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
        
    public int getReservas1() {
		return reservas1;
	}
    
    public void setReservas1(int rese) {
		reservas1 = rese;
	}
    
    public int getReservas2() {
		return reservas2;
	}
    
    public void setReservas2(int rese) {
		reservas2 = rese;
	}
    
    
    public int getIdInsumo1() {
		return idInsumo1;
	}
    
    public void setIdInsumo1(int insumo) {
		idInsumo1 = insumo;
	}
    
        public int getIdInsumo2() {
		return idInsumo2;
	}
    
    public void setIdInsumo2(int insumo) {
		idInsumo2 = insumo;
	}
    
    protected abstract double obtenerPrecio();
    
    protected abstract int obtenerExistencia(int solicitud1);
    
    protected abstract int debitarExistencia(Producto prod, int cantidad);
    
    protected abstract String [] getProveedorUrgente(int id);
}
