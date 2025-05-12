package org.cpifppiramide.interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazProfesor extends JFrame {

    public InterfazProfesor() {
        setTitle("Área del Profesor");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnVerAgenda = new JButton("Ver Agenda de Clases");
        JButton btnAnotarProgreso = new JButton("Anotar Progreso del Alumno");
        JButton btnVerAlumnos = new JButton("Ver Información de Alumnos");

        btnVerAgenda.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Ver Agenda"));
        btnAnotarProgreso.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Anotar Progreso"));
        btnVerAlumnos.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Ver Alumnos"));

        panel.add(btnVerAgenda);
        panel.add(btnAnotarProgreso);
        panel.add(btnVerAlumnos);

        add(panel);
        setVisible(true);
    }
}
