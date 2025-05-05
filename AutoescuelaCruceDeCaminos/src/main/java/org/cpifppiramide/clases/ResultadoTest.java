package org.cpifppiramide.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResultadoTest {
    private long id;
    private LocalDateTime fecha;
    private double puntuacion;
    private int vecesRespondida;
    private double procentajeAcierto;

    public ResultadoTest(long id, LocalDateTime fecha, double puntuacion, int vecesRespondida, double procentajeAcierto) {
        this.id = id;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
        this.vecesRespondida = vecesRespondida;
        this.procentajeAcierto = procentajeAcierto;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public int getVecesRespondida() {
        return vecesRespondida;
    }

    public double getProcentajeAcierto() {
        return procentajeAcierto;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "fecha: " + fecha + "\n" +
                "puntuacion: " + puntuacion + "\n" +
                "vecesRespondida: " + vecesRespondida + "\n" +
                "procentajeAcierto: " + procentajeAcierto + "\n";
    }
}
