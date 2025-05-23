package org.cpifppiramide.interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazAnotarProgreso extends JFrame {

    public InterfazAnotarProgreso() {
        setTitle("Progreso");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Nombre del alumno: "));
        JTextField nombreAlumno = new JTextField();
        panel.add(nombreAlumno);

        panel.add(new JLabel("Anotación: "));
        JTextArea anotacion = new JTextArea();
        panel.add(new JScrollPane(anotacion));

        JButton btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String nombre = nombreAlumno.getText();
            String anotacionText = anotacion.getText();
            System.out.println("Anotación de " + nombre + ": " + anotacionText);
        });

        add(panel);

        setVisible(true);
    }
}
