package org.cpifppiramide.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Alumno extends Usuario {

    private LocalDate fechaNacimiento;
    private String direccion;

    public Alumno(long id, String nombre, String apellido, String dni, String email, int telefono, String password, LocalDateTime horario, LocalDate fechaNacimiento, String direccion) {
        super(id, nombre, apellido, dni, email, telefono, password, horario);
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
       return super.toString() + "\n" + "Fecha de Nacimiento: " + fechaNacimiento + "\n" + "Direccion: " + direccion;
    }
}
