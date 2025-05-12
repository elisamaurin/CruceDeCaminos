package org.cpifppiramide.clases;

import org.cpifppiramide.enums.Opcion;

public class Pregunta {
    private long id;
    private String enunciado;
    private Opcion opcion;

    public Pregunta() {}

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

    public void setId(long id) {
        this.id = id;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "enunciado: " + enunciado + "\n" +
                "opcion: " + opcion + "\n";
    }
}
