package org.cpifppiramide.interfaz;

import javax.swing.*;

public class InterfazNotificaciones extends JFrame {
    public InterfazNotificaciones() {
        setTitle("Notificaciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea("Tienes una clase programada mañana a las 10:00\nRevisión del test pendiente");
        area.setEditable(false);
        add(new JScrollPane(area));

        setVisible(true);

    }
}
