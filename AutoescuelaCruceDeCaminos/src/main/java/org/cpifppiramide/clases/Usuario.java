package org.cpifppiramide.clases;

import java.time.LocalDateTime;

public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private int telefono;
    private String password;
    private LocalDateTime horario;

    public Usuario(long id, String nombre, String apellido, String dni, String email, int telefono, String password, LocalDateTime horario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.horario = horario;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String toString() {
        return "id: " + id + "\n" +
                "nombre: " + nombre + "\n" +
                "apellido: " + apellido + "\n" +
                "dni: " + dni + "\n" +
                "email: " + email + "\n" +
                "telefono: " + telefono + "\n" +
                "password: " + password + "\n" +
                "horario: " + horario + "\n";
    }

}
