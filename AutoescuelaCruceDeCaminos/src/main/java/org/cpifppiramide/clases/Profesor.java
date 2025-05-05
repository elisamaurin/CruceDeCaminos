package org.cpifppiramide.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profesor extends Usuario {
    private LocalDate fechaContratacion;
    public Profesor(long id, String nombre, String apellido, String dni, String email, int telefono, String password, LocalDateTime horario, LocalDate fechaContratacion) {
        super(id, nombre, apellido, dni, email, telefono, password, horario);
        this.fechaContratacion = fechaContratacion;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "fechaContratacion: " + fechaContratacion;
    }
}

