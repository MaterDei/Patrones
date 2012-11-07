/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


/**
 *
 * @author JAVIER
 */
public class Coneccion {
    
     private static Connection connection;

        public  static Connection getConexion() throws Exception{
            if (connection == null || connection.isClosed())
                    return getJDBCConnection();
                else
                    if (connection.isClosed()){
                    return getJDBCConnection();
                    }
                    return connection;
        }

       	private static   Connection getJDBCConnection() throws Exception{
		
            String host = "jdbc:mysql://localhost/borrachosBar";
            String username = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            System.out.println("DRIVER: " + driver);
            connection = (Connection) DriverManager.getConnection(host, username, password);
            System.out.println("CONNECTION: " + connection);
            return connection;
                
               
	}


	public static void cerrarConexion(){
		try{
                   connection.close();
		}catch(Exception e){
                    e.printStackTrace();
		}
	}
    
}
