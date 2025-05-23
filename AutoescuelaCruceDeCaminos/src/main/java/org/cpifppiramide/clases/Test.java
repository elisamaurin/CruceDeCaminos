package org.cpifppiramide.clases;

import org.cpifppiramide.enums.TipoTest;

import java.util.List;

public class Test {
    private long id;
    private String nombre;
    private TipoTest tipo;
    private int duracion;
    private String descripcion;
    private List<Pregunta> preguntas;

    public Test(long id, String nombre, TipoTest tipo, int duracion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    public Test(){}

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoTest getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoTest tipo) {
        this.tipo = tipo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "nombre: " + nombre + "\n" +
                "tipo: " + tipo + "\n" +
                "duracion: " + duracion + "\n" +
                "descripcion: " + descripcion + "\n";
    }
}
