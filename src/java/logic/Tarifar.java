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
        
        String rta = null;
        try {
            
            JSONObject pedido = new JSONObject();
            String[] products = new String[]{"Hamburguesa","Perro", "Cerveza"};
            int[] cantidades = new int[]{2, 10,20};
            pedido.put("productos", products);
            pedido.put("cantidades", cantidades);
           
            JSONObject recibido = new JSONObject(productos);
            JSONArray prod = recibido.getJSONArray("productos");
            JSONArray num = recibido.getJSONArray("cantidades");
               
            return recibido.toString()+prod.toString()+num.toString();
            
            /*
                for (int i = 0; i < prod.length(); i++) {
                    
                    if(num.getInt(i)!=0){
                    
                        if(prod.getString(i).equals("Hamburguesa"))
                        {
                            Hamburguesa hambur = new Hamburguesa();
                        }
                        else{
                            if (prod.getString(i).equals("Perro")){
                                Perro perro = new Perro();
                            }
                            else
                            {
                                if((prod.getString(i).equals("Cerveza")))
                                {
                                    Cerveza cerv= new Cerveza();
                                }
                                else
                                {
                                    return "Producto incorrecto";
                                }
                            }
                        
                        }
      
                    System.out.println( prod.getString(i) );
                    System.out.print("hola.....");
                    rta=prod.getString(i);
                    }
                    
                   
                }
                */ 
        } catch (JSONException ex) {
            Logger.getLogger(Tarifar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  rta;
    }
    
  
    
}
