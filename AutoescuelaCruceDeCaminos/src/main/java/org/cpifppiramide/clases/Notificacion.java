package org.cpifppiramide.clases;

import org.cpifppiramide.enums.TipoNotificacion;

public class Notificacion {
    private Long id;
    private TipoNotificacion tipo;
    private String mensaje;

    public Notificacion(Long id, TipoNotificacion tipo, String mensaje) {
        this.id = id;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "tipo: " + tipo + "\n" +
                "mensaje: " + mensaje + "\n";
    }
}
