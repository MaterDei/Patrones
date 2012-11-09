/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import connection.Coneccion;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVIER
 */
public class daoProveedor {

    Connection con;

    public String[] getProveedorUrgente(int id) throws Exception {
        try {
            con = Coneccion.getConexion();

            String consulta = "SELECT nombreProveedor, correoProveedor, nombreInsumo FROM proveedor INNER JOIN existencia WHERE idInsumo=idInsumoProveedor AND idInsumoProveedor = '" + id + "'";
            java.sql.Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(consulta);

            String[] rta = new String[3];

            if (rs.next()) {
                System.out.print("Contactar urgente a " + rs.getString("nombreProveedor"));
                rta[0] = rs.getString("nombreProveedor");
                rta[1] = rs.getString("correoProveedor");
                rta[2] = rs.getString("nombreInsumo");
            }

            sentencia.close();
            Coneccion.cerrarConexion();
            return rta;
        } catch (Exception ex) {
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
            return new String[]{"No se pudo realizar la consulta del proveedor urgente"};
        }

    }
}
