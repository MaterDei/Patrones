/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
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

    public String calcular(String codigo, String productos) {


        double total = 0;
        Hamburguesa hambur = null;
        Perro perro = null ;
        Cerveza cerv = null ;
        int cantidad = 0;
        String[] rta = new String[3];
        JSONObject pedido = new JSONObject();

        List proveedor = new ArrayList();
        List correo = new ArrayList();
        List nombreInsumo = new ArrayList();
        List precio = new ArrayList();
        String [] ayuda= new String[1];

        try {

            JSONObject recibido = new JSONObject(productos);
            JSONArray prod = recibido.getJSONArray("productos");
            JSONArray num = recibido.getJSONArray("cantidades");
         

            for (int i = 0; i < prod.length(); i++) {
                cantidad = num.getInt(i);

                if (cantidad != 0) {

                    if (prod.getString(i).equals("Hamburguesa")) {
                        hambur = new Hamburguesa();
                        if (hambur.obtenerExistencia(cantidad) == 1) 
                        {
                            total += hambur.obtenerPrecio() * num.getInt(i);
                        } else {
                            return "No hay suficiente material para preparar hamburguesas";
                        }


                    } else {
                        if (prod.getString(i).equals("Perro")) {
                            
                            perro = new Perro();

                            if (perro.obtenerExistencia(cantidad) == 1) {
                                total += perro.obtenerPrecio() * num.getInt(i);
                                
                            } else {
                                return "No hay suficiente material para preparar perros";
                            }
                        } else {
                            if ((prod.getString(i).equals("Cerveza"))) {
                                cerv = new Cerveza();
                                if (cerv.obtenerExistencia(cantidad) == 1) //cerv.setCantidad(num.getInt(i));
                                {
                                    total += cerv.obtenerPrecio() * num.getInt(i);
                                    System.out.print("cantidad" + cantidad);
                                } else {
                                    return "No hay suficientes cervezas en bodega...... que pesar";
                                }
                            } else {
                                return "Producto incorrecto";
                            }
                        }

                    }
                }
            }



            for (int i = 0; i < prod.length(); i++) {
                cantidad = num.getInt(i);

                if (prod.getString(i).equals("Hamburguesa")) {
                    hambur.debitarExistencia(hambur, cantidad);
                    if ((hambur.getReservas1() - cantidad) == 0) {
                        rta = hambur.getProveedorUrgente(hambur.getIdInsumo1());
                        proveedor.add(rta[0]);
                        correo.add(rta[1]);
                        nombreInsumo.add(rta[2]);
                    }
                    if ((hambur.getReservas2() - cantidad) == 0) {
                        rta = hambur.getProveedorUrgente(hambur.getIdInsumo2());
                        proveedor.add(rta[0]);
                        correo.add(rta[1]);
                        nombreInsumo.add(rta[2]);
                    }
                } else {
                    if (prod.getString(i).equals("Cerveza")) {
                        cerv.debitarExistencia(cerv, cantidad);
                        if ((cerv.getReservas1() - cantidad == 0)) {
                            rta = cerv.getProveedorUrgente(cerv.getIdInsumo1());
                            proveedor.add(rta[0]);
                            correo.add(rta[1]);
                            nombreInsumo.add(rta[2]);
                        }

                    } else {
                        if(prod.getString(i).equals("Perro")){
                        perro.debitarExistencia(perro, cantidad);
                        if ((perro.getReservas1() - cantidad) == 0) {
                            rta = perro.getProveedorUrgente(perro.getIdInsumo1());
                            proveedor.add(rta[0]);
                            correo.add(rta[1]);
                            nombreInsumo.add(rta[2]);
                        }
                        if (perro.getReservas2() - cantidad == 0) {
                            rta = perro.getProveedorUrgente(perro.getIdInsumo2());
                            proveedor.add(rta[0]);
                            correo.add(rta[1]);
                            nombreInsumo.add(rta[2]);
                        }
                        }
                    }
                }

            }
            
            precio.add(Double.toString(total));
            pedido.put("proveedor", proveedor);
            pedido.put("correo", correo);
            pedido.put("nombreInsumo", nombreInsumo);
            pedido.put("precio",precio);


        } catch (JSONException ex) {
            Logger.getLogger(Tarifar.class.getName()).log(Level.SEVERE, null, ex);
        }

          return pedido.toString();
    }
}
