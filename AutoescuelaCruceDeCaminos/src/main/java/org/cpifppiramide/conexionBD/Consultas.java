package org.cpifppiramide.conexionBD;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.Profesor;
import org.cpifppiramide.clases.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consultas {
    public static Usuario obtenerUsuario(String dni) {
        String query = "SELECT * FROM USUARIO WHERE DNI = '" + dni + "'";
        Connection conn = null;
        Statement stmt = null;
        Usuario usuario = null;

        try {
            conn = Conexion.connection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                int telefono = rs.getInt("telefono");
                String password = rs.getString("password");
                LocalDateTime horario = rs.getTimestamp("horario").toLocalDateTime();
                String tipo = rs.getString("tipo");

                if (tipo.equalsIgnoreCase("alumno")) {
                    String queryAlumno = "SELECT fecha_nacimiento, direccion FROM ALUMNO WHERE fk_id_usuario = " + id;
                    ResultSet rsAlumno = stmt.executeQuery(queryAlumno);
                    if (rsAlumno.next()) {
                        LocalDate fechaNacimiento = rsAlumno.getDate("fecha_nacimiento").toLocalDate();
                        String direccion = rsAlumno.getString("direccion");
                        usuario = new Alumno(id, nombre, apellido, dni, email, telefono, password, horario, tipo, fechaNacimiento, direccion);
                    }

                } else if (tipo.equalsIgnoreCase("profesor")) {
                    String queryProfesor = "SELECT fecha_contratacion FROM PROFESOR WHERE fk_id_usuario = " + id;
                    ResultSet rsProfesor = stmt.executeQuery(queryProfesor);
                    if (rsProfesor.next()) {
                        LocalDate fechaContratacion = rsProfesor.getDate("fecha_contratacion").toLocalDate();
                        usuario = new Profesor(id, nombre, apellido, dni, email, telefono, password, horario, tipo, fechaContratacion);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }
}
