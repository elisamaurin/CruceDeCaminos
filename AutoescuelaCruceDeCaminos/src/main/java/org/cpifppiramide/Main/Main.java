package org.cpifppiramide.Main;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.Profesor;
import org.cpifppiramide.clases.Usuario;
import org.cpifppiramide.conexionBD.Conexion;
import org.cpifppiramide.conexionBD.Consultas;
import org.cpifppiramide.interfaz.InterfazAlumno;
import org.cpifppiramide.interfaz.InterfazProfesor;
import org.cpifppiramide.interfaz.VentanaPrincipal;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Usuario usuario  = Consultas.obtenerUsuario("12345678W");
        if(usuario instanceof Alumno){
            InterfazAlumno interfazAlumno = new InterfazAlumno();
            interfazAlumno.setVisible(true);
        } else if (usuario instanceof Profesor){
            InterfazProfesor interfazProfesor = new InterfazProfesor();
            interfazProfesor.setVisible(true);
        }else{
            System.out.println("Usuario no encontrado");
        }
    }
}
