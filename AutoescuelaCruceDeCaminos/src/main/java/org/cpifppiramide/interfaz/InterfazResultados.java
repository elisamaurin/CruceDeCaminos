package org.cpifppiramide.interfaz;

import javax.swing.*;

public class InterfazResultados extends JFrame {

    public InterfazResultados() {
       setTitle("Resultados");
       setSize(500, 300);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);

       String[] columnas = {"Test", "Nota", "Veces respondida", "Porcentaje de aciertos"};
       Object[][] filas = {
               {"Test 1", 10, 10, 100},
               {"Test 2", 10, 10, 100},
       };

       JTable tabla = new JTable(filas, columnas);
       JScrollPane scroll = new JScrollPane(tabla);
       add(scroll);
       setVisible(true);


    }
}
