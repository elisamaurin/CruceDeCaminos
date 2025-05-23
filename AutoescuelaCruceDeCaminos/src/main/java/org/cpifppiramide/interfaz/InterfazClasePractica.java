package org.cpifppiramide.interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazClasePractica extends JFrame {
    public InterfazClasePractica(){
        setTitle("Clase práctica");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnProgramarClase = new JButton("Programar clase");
        JButton btnEscribirAnotaciones = new JButton("Escribir anotaciones");
        JButton btnEliminarAnotaciones = new JButton("Eliminar anotaciones");


        btnProgramarClase.addActionListener(e -> JOptionPane.showMessageDialog(null, "Programar clase"));


        btnEscribirAnotaciones.addActionListener(e -> JOptionPane.showMessageDialog(null, "Escribir anotaciones"));


        btnEliminarAnotaciones.addActionListener(e -> JOptionPane.showMessageDialog(null, "Eliminar anotaciones"));

        panel.add(btnProgramarClase);
        panel.add(btnEscribirAnotaciones);
        panel.add(btnEliminarAnotaciones);

        add(panel);
        setVisible(true);
    }
}
