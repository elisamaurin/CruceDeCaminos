package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.Pregunta;
import org.cpifppiramide.clases.Test;
import org.cpifppiramide.enums.Opcion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InterfazAlumno extends JFrame {
    private Alumno alumno;
    private Test test;
    private List<Pregunta> preguntas;
    public InterfazAlumno() {
        setTitle("Área del alumno");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        final List<String> respuestas = new ArrayList<>();
        for(int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            JPanel preguntaPanel = new JPanel(new GridLayout(2,1));
            JLabel preguntaLabel = new JLabel(pregunta.getEnunciado());
            preguntaPanel.add(preguntaLabel);

            JPanel opcionesPanel = new JPanel(new FlowLayout());
            JButton botonOpcionA = new JButton("A)" + Opcion.A);
            JButton botonOpcionB = new JButton("B)" + Opcion.B);
            JButton botonOpcionC = new JButton("C)" + Opcion.C);

            int finalI = i;
            botonOpcionA.addActionListener(e -> respuestas.add(finalI, Opcion.A.name()));


        }

        JButton btnRealizarTest = new JButton("Realizar Test");
        JButton btnVerHistorial = new JButton("Ver Historial de Tests");
        JButton btnReservarClase = new JButton("Reservar Clase Práctica");
        JButton btnVerNotificaciones = new JButton("Ver Notificaciones");

        // Aquí puedes agregar listeners para que hagan acciones reales
        btnRealizarTest.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Realizar Test"));
        btnVerHistorial.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Ver Historial"));
        btnReservarClase.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Reservar Clase"));
        btnVerNotificaciones.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Notificaciones"));

        panel.add(btnRealizarTest);
        panel.add(btnVerHistorial);
        panel.add(btnReservarClase);
        panel.add(btnVerNotificaciones);

        add(panel);
        setVisible(true);

    }
}
