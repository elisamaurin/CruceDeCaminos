package org.cpifppiramide.clases;

public class Respuesta {
    private Long id;
    private boolean esCorrecta;

    public Respuesta(Long id, boolean esCorrecta) {
        this.id = id;
        this.esCorrecta = esCorrecta;
    }

    public Long getId() {
        return id;
    }

    public boolean getEsCorrecta() {
        return esCorrecta;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "esCorrecta: " + esCorrecta + "\n";
    }
}
