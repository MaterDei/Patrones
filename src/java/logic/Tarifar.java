/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author JAVIER
 */
public class Tarifar {
    
    public String  calcular(String codigo, String productos){
        

        double total=0;
        Hamburguesa hambur = new Hamburguesa();
        Perro perro = new Perro();
        Cerveza cerv= new Cerveza();
        int cantidad=0;
        
        try {
           
            JSONObject recibido = new JSONObject(productos);
            JSONArray prod = recibido.getJSONArray("productos");
            JSONArray num = recibido.getJSONArray("cantidades");
            
            
                for ( int i = 0; i < prod.length(); i++) {
                    cantidad=num.getInt(i);
                    
                    if(cantidad!=0){
                    
                        if(prod.getString(i).equals("Hamburguesa"))
                        {
                            if(hambur.obtenerExistencia(cantidad)==1)
                            //hambur.setCantidad(num.getInt(i));
                            total+=hambur.obtenerPrecio()*num.getInt(i);
                            else
                                return "No hay suficiente material para preparar hamburguesas";
                            
                            
                        }
                        else{
                            if (prod.getString(i).equals("Perro")){
                                
                                if(perro.obtenerExistencia(cantidad)==1)
                               // perro.setCantidad(num.getInt(i));
                                total+=perro.obtenerPrecio()*num.getInt(i);
                                else
                                    return "No hay suficiente material para prepara perros";
                            }
                            else
                            {
                                if((prod.getString(i).equals("Cerveza")))
                                {
                                    if(cerv.obtenerExistencia(cantidad)==1)
                                    //cerv.setCantidad(num.getInt(i));
                                    total+=cerv.obtenerPrecio()*num.getInt(i);
                                    else
                                        return "No hay suficientes cervezas en bodega...... que pesar";
                                }
                                else
                                {
                                    return "Producto incorrecto";
                                }
                            }
                        
                        }
                    }
                    
                   
                }
                
        } catch (JSONException ex) {
            Logger.getLogger(Tarifar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Double.toString(total);
    }
    
  
    
}
