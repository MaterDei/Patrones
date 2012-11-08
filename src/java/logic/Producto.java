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
    private static int reservas1;
    private static int reservas2;
    
    
   
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
    

    
    
    
    
    protected abstract double obtenerPrecio();
    
    protected abstract int obtenerExistencia(int solicitud1);
}
