package org.cpifppiramide.clases;

import org.cpifppiramide.enums.TipoTest;

public class Test {
    private long id;
    private String nombre;
    private TipoTest tipo;
    private int duracion;
    private String descripcion;

    public Test(long id, String nombre, TipoTest tipo, int duracion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

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

    public String toString() {
        return "id: " + id + "\n" +
                "nombre: " + nombre + "\n" +
                "tipo: " + tipo + "\n" +
                "duracion: " + duracion + "\n" +
                "descripcion: " + descripcion + "\n";
    }
}
