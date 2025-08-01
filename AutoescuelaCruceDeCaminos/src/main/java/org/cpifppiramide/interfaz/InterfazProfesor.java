package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.ClasePractica;
import org.cpifppiramide.clases.Profesor;
import org.cpifppiramide.conexionBD.Conexion;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        JButton btnEditarHorario = new JButton("Editar horario");
        JButton btnModificarPassword = new JButton("Modificar Password");
        JButton btnGestionarClases = new JButton("Gestionar Clases");
        JButton btnSalir = new JButton("Cerrar sesión");


        btnVerAgenda.addActionListener(e ->{
            List<ClasePractica> clases = List.of(
                    new ClasePractica(1, java.time.LocalDate.of(2025,5,22), 60, "Sin observaciones"),
                    new ClasePractica(2, java.time.LocalDate.of(2025,5,23), 90, "Clase avanzada")
            );

            List<Alumno> alumnos = List.of(

            );

            new InterfazMostrarClases(clases, alumnos);
        });
        btnAnotarProgreso.addActionListener(e -> {
            new InterfazAnotarProgreso();
        });
        btnEditarHorario.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Editar Horario"));
        btnModificarPassword.addActionListener(e -> JOptionPane.showMessageDialog(this, "Función: Modificar Password"));

        btnGestionarClases.addActionListener(e -> new InterfazClasePractica());
        btnSalir.addActionListener(e ->{
            dispose();
            new VentanaPrincipal();
        });

        panel.add(btnVerAgenda);
        panel.add(btnAnotarProgreso);
        panel.add(btnEditarHorario);
        panel.add(btnModificarPassword);
        panel.add(btnGestionarClases);
        panel.add(btnSalir);

        add(panel);
        setVisible(true);
    }
}
