package org.cpifppiramide.conexionBD;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    public static Connection connection(){
        Properties props = new Properties();
        try{
            props.load(new FileReader("config.properties"));
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.printf("Conexion creada a la base de datos");
            return conexion;
        }catch (IOException | SQLException e){
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
            return null;
        }
    }
}
