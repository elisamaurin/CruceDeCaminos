package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.Pregunta;
import org.cpifppiramide.clases.Test;
import org.cpifppiramide.conexionBD.Consultas;
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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnRealizarTest = new JButton("Realizar test");
        JButton btnVerHistorial = new JButton("Ver resultados");
        JButton btnReservarClase = new JButton("Reservar clase práctica");
        JButton btnVerNotificaciones = new JButton("Ver notificaciones");
        JButton btnModificarPassword = new JButton("Modificar password");
        JButton btnModificarHorario = new JButton("Editar horario");
        JButton btnVerClases = new JButton("Ver clases practicas");
        JButton btnSalir = new JButton("Cerrar sesión");

        btnRealizarTest.addActionListener(e -> {
            List<Test> tests = Consultas.obtenerTestsConPreguntas();

            if (!tests.isEmpty()) {
                Test test = tests.get(0);
                new InterfazTest(test);
            } else {
                JOptionPane.showMessageDialog(this, "No hay tests disponibles.");
            }
        });
        btnVerHistorial.addActionListener(e ->{
            new InterfazResultados();
        });
        btnReservarClase.addActionListener(e -> {
            new InterfazReservarClase(alumno);
        });
        btnVerNotificaciones.addActionListener(e -> {
            new InterfazNotificaciones();
        });
        btnModificarPassword.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Modificar Password"));
        btnModificarHorario.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Modificar Horario"));
        btnVerClases.addActionListener(e -> new InterfazClasePractica());
        btnSalir.addActionListener(e -> {
            dispose();
            new VentanaPrincipal();
        });

        panel.add(btnRealizarTest);
        panel.add(btnVerHistorial);
        panel.add(btnReservarClase);
        panel.add(btnVerNotificaciones);
        panel.add(btnModificarPassword);
        panel.add(btnModificarHorario);
        panel.add(btnVerClases);
        panel.add(btnSalir);

        add(panel);
        setVisible(true);

    }
}
