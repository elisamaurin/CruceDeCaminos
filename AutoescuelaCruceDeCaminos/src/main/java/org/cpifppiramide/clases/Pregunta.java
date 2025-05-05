package org.cpifppiramide.clases;

import org.cpifppiramide.enums.Opcion;

public class Pregunta {
    private long id;
    private String enunciado;
    private Opcion opcion;

    public Pregunta(long id, String enunciado, Opcion opcion) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcion = opcion;
    }

    public long getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "enunciado: " + enunciado + "\n" +
                "opcion: " + opcion + "\n";
    }
}
