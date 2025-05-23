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
    private List<ClasePractica> clasePracticas;
    private List<Test>tests;
    private List<Notificacion>notificaciones;

    public Alumno(long id, String nombre, String apellido, String dni, String email, int telefono, String password, String tipo, LocalDate fechaNacimiento, String direccion) {
        super(id, nombre, apellido, dni, email, telefono, password, tipo);
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

    public void inscribirClasePractica(ClasePractica clasePractica) {
        if(!clasePracticas.contains(clasePractica)) {
            clasePracticas.add(clasePractica);
            System.out.println("Alumno inscrito en la clase práctica: " + clasePractica.getId());
        }else{
            System.out.println("El alumno ya está inscrito en la clase práctica: " + clasePractica.getId());
        }
    }

    public void realizarTest(Test test, List<Opcion> opciones) {
        if(test.getPreguntas().size() != opciones.size()) {
            System.out.println("El número de preguntas no coincide con el número de opciones seleccionadas.");
            return;
        }
        int aciertos = 0;
        for (int i = 0; i < test.getPreguntas().size(); i++) {
            if(test.getPreguntas().get(i).getRespuestaCorrecta().equals(opciones.get(i))) {
                aciertos++;
            }
        }
    }


}
