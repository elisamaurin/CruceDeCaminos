package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Alumno;

import javax.swing.*;
import java.awt.*;

public class InterfazReservarClase extends JFrame {

    public InterfazReservarClase(Alumno alumno) {
        setTitle("Reservar Clase");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Fecha: "));
        JTextField campoFecha = new JTextField();
        panel.add(campoFecha);

        panel.add(new JLabel("Hora: "));
        JTextField campoHora = new JTextField();
        panel.add(campoHora);

        JButton botonReservar = new JButton("Reservar");
        botonReservar.addActionListener(e -> {
            JOptionPane.showMessageDialog(InterfazReservarClase.this, "Clase reservada con éxito");
            dispose();
        });

        panel.add(botonReservar);
        add(panel);
        setVisible(true);
    }
}
