package org.cpifppiramide.interfaz;

import org.cpifppiramide.clases.Alumno;
import org.cpifppiramide.clases.Profesor;
import org.cpifppiramide.clases.Usuario;
import org.cpifppiramide.conexionBD.Consultas; // Asumo que el método iniciarSesion está aquí

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private JTextField txtDni;
    private JPasswordField txtPassword;
    public VentanaPrincipal() {

        setTitle("Cruce de caminos - Login");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panel.add(txtDni);

        panel.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        JButton btnLogin = new JButton("Iniciar sesión");

        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> {
            String dni = txtDni.getText().trim();
            String password = new String(txtPassword.getPassword());

            Usuario usuarioLogeado = Consultas.iniciarSesion(dni, password);

            if (usuarioLogeado != null) {
                if (usuarioLogeado instanceof Alumno) {
                    new InterfazAlumno();
                } else if (usuarioLogeado instanceof Profesor) {
                   new InterfazProfesor();
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "DNI o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
