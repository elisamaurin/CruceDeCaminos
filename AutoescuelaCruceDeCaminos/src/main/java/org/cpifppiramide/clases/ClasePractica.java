package org.cpifppiramide.clases;

import java.time.Duration;
import java.time.LocalDate;

public class ClasePractica {
    private long id;
    private LocalDate fecha;
    private int duracion;
    private String observaciones;

    public ClasePractica(long id, LocalDate fecha, int duracion, String observaciones) {
        this.id = id;
        this.fecha = fecha;
        this.duracion = duracion;
        this.observaciones = observaciones;
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

    public String toString() {
        return "id: " + id + "\n" +
                "fecha: " + fecha + "\n" +
                "duracion: " + duracion + "\n" +
                "observaciones: " + observaciones + "\n";
    }


}
