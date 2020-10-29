package com.luish.myslq_001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Luis
 */
public class PruebaMySQL {

    public static void main(String[] args) {

        // Conexiones
        Connection conexion1 = null;
        Connection conexion2 = null;
        Connection conexion3 = null;

        // Usuario y clave
        String user = "root";
        String password = "";

        try {

            // Una sola cadena de conexión, en un solo parámetro se concatena el 
            // usuario y el password
            String url1 = "jdbc:mysql://localhost:3306/mibase?user=" + user + "&password" + password;
            conexion1 = DriverManager.getConnection(url1);

            if (conexion1 != null) {
                System.out.println("Conexión 1: Conexión a mibase satisfactoria");
            }

            // Se envía la cadena y los datos de usuario y password por separado
            Properties datos = new Properties();
            datos.put("user", user);
            datos.put("password", password);
            String url2 = "jdbc:mysql://localhost:3306/mibase";
            conexion2 = DriverManager.getConnection(url2, datos);

            if (conexion2 != null) {
                System.out.println("Conexión 2: Conexión a mibase satisfactoria");
            }

            // Se envía la cadena, usuario y password por separado
            String url3 = "jdbc:mysql://localhost:3306/mibase";
            conexion3 = DriverManager.getConnection(url3, user, password);

            if (conexion3 != null) {
                System.out.println("Conexión 3: Conexión a mibase satisfactoria");
            }
        } catch (SQLException e) {
            System.out.println("Error, verifique su usuario o password o nombre de la base de datos");
            e.printStackTrace();
        }
    }
}
