package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.Profesor;
import org.cpifppiramide.clases.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(Usuario usuario) {
        setTitle("Cruce de caminos");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));

        if(usuario instanceof Alumno){

            JButton botonAlumno = new JButton("Entrar como alumno");
            botonAlumno.addActionListener(e -> {
                new InterfazAlumno();
                dispose();
            });

            panel.add(botonAlumno);
        } else if (usuario instanceof Profesor) {
            JButton botonProfesor = new JButton("Entrar como profesor");
            botonProfesor.addActionListener(e -> {
                new InterfazProfesor();
                dispose();
            });
            panel.add(botonProfesor);
        }
        add(panel);
    }
}
