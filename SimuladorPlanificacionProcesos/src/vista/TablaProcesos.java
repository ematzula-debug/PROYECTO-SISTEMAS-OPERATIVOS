
package vista;

import modelo.Proceso;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TablaProcesos extends JFrame {

    private final JTable tabla;
    private final DefaultTableModel modeloTabla;

    public TablaProcesos(List<Proceso> listaProcesos) {
        setTitle("📋 Tabla de Procesos");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Columnas de la tabla
        String[] columnas = {
        "PID", "Nombre", "Llegada", "Ejecución", "Quantun",
        "Estado", "Restante", "Finalización"
        };

        // Convertir lista a matriz
        Object[][] datos = convertirListaAArray(listaProcesos);

        // Modelo de tabla
        modeloTabla = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Las celdas no son editables por defecto
            }
        };

        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);

        // Aquí se pueden agregar botones en el futuro
        JPanel botones = new JPanel();
        botones.add(new JButton("Ejecutar"));
        botones.add(new JButton("Eliminar"));
        botones.add(new JButton("Modificar"));
        panel.add(botones, BorderLayout.SOUTH);

        add(panel);
    }

    // Método auxiliar para convertir lista en matriz
    private Object[][] convertirListaAArray(List<Proceso> lista) {
        Object[][] matriz = new Object[lista.size()][];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i] = lista.get(i).toArray();
        }
        return matriz;
    }

    // Método para mostrar la ventana
    public void mostrar() {
        setVisible(true);
    }
}