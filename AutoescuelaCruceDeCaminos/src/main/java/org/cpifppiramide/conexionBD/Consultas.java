package org.cpifppiramide.conexionBD;

import org.cpifppiramide.clases.*;
import org.cpifppiramide.enums.Opcion;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                        usuario = new Alumno(id, nombre, apellido, dni, email, telefono, password, tipo, fechaNacimiento, direccion);
                    }

                } else if (tipo.equalsIgnoreCase("profesor")) {
                    String queryProfesor = "SELECT fecha_contratacion FROM PROFESOR WHERE fk_id_usuario = " + id;
                    ResultSet rsProfesor = stmt.executeQuery(queryProfesor);
                    if (rsProfesor.next()) {
                        LocalDate fechaContratacion = rsProfesor.getDate("fecha_contratacion").toLocalDate();
                        usuario = new Profesor(id, nombre, apellido, dni, email, telefono, password, tipo, fechaContratacion);
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

    public static Usuario iniciarSesion(String dni, String password) {
        String query = "SELECT * FROM USUARIO WHERE DNI = ? AND PASSWORD = ?";
        try(Connection conn = Conexion.connection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dni);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                int telefono = rs.getInt("telefono");
                String tipo = rs.getString("tipo");

                if (tipo.equalsIgnoreCase("alumno")) {
                    PreparedStatement psAlumno = conn.prepareStatement("SELECT fecha_nacimiento, direccion FROM ALUMNO WHERE fk_id_usuario = ?");
                    psAlumno.setLong(1, id);
                    ResultSet rsAlumno = psAlumno.executeQuery();
                    if (rsAlumno.next()) {
                        LocalDate fechaNacimiento = rsAlumno.getDate("fecha_nacimiento").toLocalDate();
                        String direccion = rsAlumno.getString("direccion");
                        return new Alumno(id, nombre, apellido, dni, email, telefono, password, tipo, fechaNacimiento, direccion);
                    }
                } else if (tipo.equalsIgnoreCase("profesor")) {
                    PreparedStatement psProfesor = conn.prepareStatement("SELECT fecha_contratacion FROM PROFESOR WHERE fk_id_usuario = ?");
                    psProfesor.setLong(1, id);
                    ResultSet rsProfesor = psProfesor.executeQuery();
                    if (rsProfesor.next()) {
                        LocalDate fechaContratacion = rsProfesor.getDate("fecha_contratacion").toLocalDate();
                        return new Profesor(id, nombre, apellido, dni, email, telefono, password, tipo, fechaContratacion);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String recuperarPassword(String dni) {
        String query = "SELECT PASSWORD FROM USUARIO WHERE DNI = '" + dni + "'";
        try(Connection conn = Conexion.connection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean cambiarPassword(String dni, String nuevaPassword) {
        String query = "UPDATE USUARIO SET PASSWORD = ? WHERE DNI = ?";
        try(Connection conn = Conexion.connection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nuevaPassword);
            ps.setString(2, dni);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Test> obtenerTestsConPreguntas() {
        List<Test> tests = new ArrayList<>();

        String queryTests = "SELECT * FROM TEST";

        try (Connection conn = Conexion.connection();
             Statement stmtTests = conn.createStatement();
             ResultSet rsTests = stmtTests.executeQuery(queryTests)) {

            while (rsTests.next()) {
                Test test = new Test();
                test.setId(rsTests.getInt("id"));
                test.setNombre(rsTests.getString("nombre"));
                List<Pregunta> preguntas = new ArrayList<>();

                String queryPreguntas = "SELECT * FROM PREGUNTA WHERE fk_id_test = " + test.getId();
                try (Statement stmtPreguntas = conn.createStatement();
                     ResultSet rsPreguntas = stmtPreguntas.executeQuery(queryPreguntas)) {

                    while (rsPreguntas.next()) {
                        Pregunta pregunta = new Pregunta();
                        pregunta.setId(rsPreguntas.getInt("id"));
                        pregunta.setEnunciado(rsPreguntas.getString("enunciado"));
                        String opcion = rsPreguntas.getString("opcion");
                        pregunta.setOpcion(Opcion.valueOf(opcion));
                        preguntas.add(pregunta);
                    }
                }

                test.setPreguntas(preguntas);
                tests.add(test);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar tests y preguntas: " + e.getMessage());
        }

        return tests;
    }

    public static List<Pregunta> cargarPreguntas(int idTest) {
        List<Pregunta> lista = new ArrayList<>();
        String query = "SELECT * FROM PREGUNTA WHERE fk_id_test = " + idTest;

        try (Connection conn = Conexion.connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Pregunta pregunta = new Pregunta();
                pregunta.setId(rs.getInt("id"));
                pregunta.setEnunciado(rs.getString("enunciado"));
                String opcion = rs.getString("opcion");
                pregunta.setOpcion(Opcion.valueOf(opcion));
                lista.add(pregunta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar preguntas: " + e.getMessage());
        }

        return lista;
    }



    public static List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String queryUsuarios = "SELECT * FROM USUARIO";

        try (Connection conn = Conexion.connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryUsuarios)) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int telefono = rs.getInt("telefono");
                String password = rs.getString("password");
                LocalDateTime horario = rs.getTimestamp("horario").toLocalDateTime();
                String tipo = rs.getString("tipo");

                if (tipo.equalsIgnoreCase("alumno")) {
                    String queryAlumno = "SELECT fecha_nacimiento, direccion FROM ALUMNO WHERE fk_id_usuario = " + id;
                    try (Statement stmtAlumno = conn.createStatement();
                         ResultSet rsAlumno = stmtAlumno.executeQuery(queryAlumno)) {
                        if (rsAlumno.next()) {
                            LocalDate fechaNacimiento = rsAlumno.getDate("fecha_nacimiento").toLocalDate();
                            String direccion = rsAlumno.getString("direccion");
                            usuarios.add(new Alumno(id, nombre, apellido, dni, email, telefono, password, tipo, fechaNacimiento, direccion));
                        }
                    }
                } else if (tipo.equalsIgnoreCase("profesor")) {
                    String queryProfesor = "SELECT fecha_contratacion FROM PROFESOR WHERE fk_id_usuario = " + id;
                    try (Statement stmtProfesor = conn.createStatement();
                         ResultSet rsProfesor = stmtProfesor.executeQuery(queryProfesor)) {
                        if (rsProfesor.next()) {
                            LocalDate fechaContratacion = rsProfesor.getDate("fecha_contratacion").toLocalDate();
                            usuarios.add(new Profesor(id, nombre, apellido, dni, email, telefono, password, tipo, fechaContratacion));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public static List<ClasePractica> obtenerClasesDeProfesor(long idProfesor) {
        List<ClasePractica> listaClases = new ArrayList<>();

        String query = """
        SELECT cp.id AS cp_id, cp.fecha, cp.duracion, cp.observaciones,
               u.id AS user_id, u.nombre, u.apellido, u.dni, u.email, u.telefono, u.password, u.tipo,
               a.fecha_nacimiento, a.direccion
        FROM CLASE_PRACTICA cp
        JOIN ALUMNO a ON cp.fk_id_alumno = a.fk_id_usuario
        JOIN USUARIO u ON a.fk_id_usuario = u.id
        WHERE cp.fk_id_profesor = ?
        """;

        try (Connection conn = Conexion.connection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setLong(1, idProfesor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                long idAlumno = rs.getLong("user_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int telefono = rs.getInt("telefono");
                String password = rs.getString("password");
                String tipo = rs.getString("tipo");
                LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                String direccion = rs.getString("direccion");

                Alumno alumno = new Alumno(idAlumno, nombre, apellido, dni, email, telefono, password, tipo, fechaNacimiento, direccion);

                // Datos de la clase práctica
                long idClase = rs.getLong("cp_id");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                int duracion = rs.getInt("duracion");
                String observaciones = rs.getString("observaciones");

                ClasePractica clase = new ClasePractica(idClase, fecha, duracion, observaciones);
                clase.setAlumno(alumno); // asignamos el alumno a la clase

                listaClases.add(clase);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener clases del profesor: " + e.getMessage());
        }

        return listaClases;
    }


}
