package org.cpifppiramide.Main;

import org.cpifppiramide.conexionBD.Conexion;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection conexion = Conexion.connection();
        if (conexion != null) {
            System.out.println("¡Conectado a la base de datos de AWS RDS!");
        } else {
            System.out.println("No se pudo conectar.");
        }

    }
}
