package org.cpifppiramide.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Profesor extends Usuario {
    private LocalDate fechaContratacion;
    private List<ClasePractica> clasePracticas;
    public Profesor(long id, String nombre, String apellido, String dni, String email, int telefono, String password,String tipo, LocalDate fechaContratacion) {
        super(id, nombre, apellido, dni, email, telefono, password, tipo);
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

    public void verDisponibilidad(){
        if(clasePracticas.isEmpty()){
            System.out.println("No hay clases disponibles");
        }else{
            System.out.println("Clases asignadas al profesor");
            for (ClasePractica clasePractica : clasePracticas) {
                System.out.println("Clase: " + clasePractica);
            }
        }
    }


}

