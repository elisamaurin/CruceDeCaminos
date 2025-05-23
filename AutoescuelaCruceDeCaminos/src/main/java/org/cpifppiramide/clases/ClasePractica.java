package org.cpifppiramide.clases;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClasePractica {
    private long id;
    private LocalDate fecha;
    private int duracion;
    private String observaciones;
    private Alumno alumno;

    public ClasePractica(long id, LocalDate fecha, int duracion, String observaciones) {
        this.id = id;
        this.fecha = fecha;
        this.duracion = duracion;
        this.observaciones = observaciones;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public boolean impartirClase(ClasePractica clasePractica){
        List<ClasePractica> clases = new ArrayList<>();
        if(estaDisponible(clasePractica.getFecha())){
            clases.add(clasePractica);
            return true;
        }
        return false;
    }

    public boolean estaDisponible(LocalDate fecha){
        List<ClasePractica> clases = new ArrayList<>();
        for(ClasePractica clasePractica : clases){
            if(clasePractica.getFecha().equals(fecha)){
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "fecha: " + fecha + "\n" +
                "duracion: " + duracion + "\n" +
                "observaciones: " + observaciones + "\n";
    }


}
