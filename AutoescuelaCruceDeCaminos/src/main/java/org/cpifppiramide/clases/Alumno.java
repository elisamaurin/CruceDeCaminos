package org.cpifppiramide.clases;

import org.cpifppiramide.conexionBD.Conexion;
import org.cpifppiramide.enums.Opcion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alumno extends Usuario {

    private LocalDate fechaNacimiento;
    private String direccion;

    public Alumno(long id, String nombre, String apellido, String dni, String email, int telefono, String password, LocalDateTime horario, String tipo, LocalDate fechaNacimiento, String direccion) {
        super(id, nombre, apellido, dni, email, telefono, password, horario, tipo);
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public static void realizarTest(Test test) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        int puntuacion = 0;
        int totalPreguntas = 0;
        try {
           conn = Conexion.connection();
           stm = conn.createStatement();
           String queryPreguntas = "SELECT * FROM pregunta WHERE fk_id_test = " + test.getId();
           rs = stm.executeQuery(queryPreguntas);

           List<Pregunta> preguntas = new ArrayList<>();
           while (rs.next()) {
               Pregunta pregunta = new Pregunta();
               pregunta.setId(rs.getInt("id"));
               pregunta.setEnunciado(rs.getString("enunciado"));
               String opcion = rs.getString("opcion");
               pregunta.setOpcion(Opcion.valueOf(opcion));
               preguntas.add(pregunta);
           }
            Scanner sc = new Scanner(System.in);
            for (Pregunta pregunta : preguntas) {
                totalPreguntas++;
                System.out.println(pregunta.getEnunciado());
                int respuesta = sc.nextInt();
                if (respuesta == pregunta.getOpcion().getRespuesta()) {
                    puntuacion++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static

    @Override
    public String toString() {
       return super.toString() + "\n" + "Fecha de Nacimiento: " + fechaNacimiento + "\n" + "Direccion: " + direccion;
    }
}
