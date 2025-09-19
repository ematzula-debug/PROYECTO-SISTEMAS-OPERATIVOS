


package simulador;

import modelo.Proceso;
import util.GeneradorPID;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Simulador de Planificación de Procesos iniciado...");
        // Inicializar lista de procesos
        ArrayList<Proceso> listaProcesos = new ArrayList<>();

        // Inicializar generador de PID
        GeneradorPID generador = new GeneradorPID();

        // Crear procesos de prueba
        listaProcesos.add(new Proceso(generador.generar(), "Proceso A", 0, 5, 2));
        listaProcesos.add(new Proceso(generador.generar(), "Proceso B", 1, 3, 2));
        listaProcesos.add(new Proceso(generador.generar(), "Proceso C", 2, 4, 2));

        // Validar procesos
        for (Proceso p : listaProcesos) {
            if (!p.validar()) {
                System.out.println("❌ Error en proceso: " + p.getNombre());
                return;
            }
        }

        // Mostrar procesos creados
        System.out.println("✅ Procesos listos para planificación:");
        for (Proceso p : listaProcesos) {
            System.out.println(p);
        }
        
        // Convertir lista a matriz para JTable
        Object[][] matrizProcesos = convertirListaAArray(listaProcesos);

        // Simulación de cómo se usaría en una JTable (solo impresión por ahora)
        System.out.println("\n📋 Datos para tabla:");
        String[] columnas = {"PID", "Nombre", "Llegada", "Ejecución", "Quantun"};
        for (Object[] fila : matrizProcesos) {
            for (Object celda : fila) {
                System.out.print(celda + "\t");
            }
            System.out.println();
        }
    }

    // Método auxiliar para convertir lista de procesos en matriz
    public static Object[][] convertirListaAArray(ArrayList<Proceso> lista) {
        Object[][] matriz = new Object[lista.size()][];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i] = lista.get(i).toArray();
        }
        return matriz;

        // Aquí podrías enviar la lista a los algoritmos de planificación
        // Ejemplo: PlanificadorFCFS.ejecutar(listaProcesos);
    }
}
    
