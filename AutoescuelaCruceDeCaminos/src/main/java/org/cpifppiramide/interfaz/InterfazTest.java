package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Pregunta;
import org.cpifppiramide.clases.Test;
import org.cpifppiramide.enums.Opcion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import static org.cpifppiramide.conexionBD.Consultas.cargarPreguntas;

public class InterfazTest extends JFrame {
    private Test test;
    private List<Pregunta> preguntas;
    private List<ButtonGroup> gruposOpciones;

    public InterfazTest(Test test) {
        this.test = test;
        this.preguntas = cargarPreguntas((int) test.getId());

        setTitle("Realizar Test: " + test.getNombre());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        gruposOpciones = new ArrayList<>();

        for (Pregunta pregunta : preguntas) {
            JPanel panelPregunta = new JPanel();
            panelPregunta.setLayout(new BoxLayout(panelPregunta, BoxLayout.Y_AXIS));
            panelPregunta.setBorder(BorderFactory.createTitledBorder("Pregunta " + pregunta.getId()));

            JLabel labelEnunciado = new JLabel(pregunta.getEnunciado());
            panelPregunta.add(labelEnunciado);

            ButtonGroup grupo = new ButtonGroup();
            gruposOpciones.add(grupo);

            for (Opcion opcion : Opcion.values()) {
                JRadioButton rb = new JRadioButton(opcion.name());
                rb.setActionCommand(opcion.name());
                grupo.add(rb);
                panelPregunta.add(rb);
            }

            panelPrincipal.add(panelPregunta);
        }

        JButton btnFinalizar = new JButton("Finalizar Test");
        btnFinalizar.addActionListener(this::finalizarTest);

        JScrollPane scroll = new JScrollPane(panelPrincipal);
        add(scroll, BorderLayout.CENTER);
        add(btnFinalizar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void finalizarTest(ActionEvent e) {
        int puntuacion = 0;

        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            ButtonGroup grupo = gruposOpciones.get(i);
            ButtonModel seleccion = grupo.getSelection();

            if (seleccion != null) {
                String respuesta = seleccion.getActionCommand();
                if (respuesta.equals(pregunta.getOpcion().name())) {
                    puntuacion++;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Has obtenido " + puntuacion + " puntos de " + preguntas.size());
        dispose();
    }
}
