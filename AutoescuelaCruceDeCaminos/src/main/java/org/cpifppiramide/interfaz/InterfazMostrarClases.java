package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.ClasePractica;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazMostrarClases extends JFrame {

    public InterfazMostrarClases(List<ClasePractica> clases, List<Alumno> alumnos){
        setTitle("Clases programadas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea textoClases = new JTextArea();
        textoClases.setEditable(false);

        if (clases.isEmpty()) {
            textoClases.setText("No tienes clases programadas.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (ClasePractica c : clases) {
                Alumno a = c.getAlumno();
                sb.append("Fecha: ").append(c.getFecha())
                        .append(" - Duración: ").append(c.getDuracion()).append(" min")
                        .append(" - Alumno: ").append(a.getNombre()).append(" ").append(a.getApellido())
                        .append("\n");
            }
            textoClases.setText(sb.toString());
        }

        JScrollPane scroll = new JScrollPane(textoClases);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}
