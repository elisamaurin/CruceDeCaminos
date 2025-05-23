package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Usuario;

import javax.swing.*;
import java.awt.*;

public class InterfazModificarPassword extends JFrame {
    public InterfazModificarPassword(Usuario usuario) {
        setTitle("Modificar contraseña");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Contraseña actual:"));
        JPasswordField actual = new JPasswordField();
        panel.add(actual);

        panel.add(new JLabel("Nueva contraseña:"));
        JPasswordField nueva = new JPasswordField();
        panel.add(nueva);

        JButton guardar = new JButton("Guardar");
        guardar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Contraseña modificada correctamente"));
        panel.add(guardar);

        add(panel);
        setVisible(true);
    }
}
