/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmo;
import Modelos.Proceso;
import java.util.*;

/**
 *
 * @author danny
 */
public class RoundRobin {
    private int quantum;

    public RoundRobin(int quantum) {
        this.quantum = quantum;
    }

    public List<Proceso> planificar(List<Proceso> procesos) {
        Queue<Proceso> cola = new LinkedList<>(procesos);
        List<Proceso> resultado = new ArrayList<>();
        int tiempo = 0;

        while (!cola.isEmpty()) {
            Proceso actual = cola.poll();
            int ejecutar = Math.min(quantum, actual.getTiempoRestante());
            actual.setTiempoRestante(actual.getTiempoRestante() - ejecutar);
            resultado.add(actual);
            tiempo += ejecutar;

            if (actual.getTiempoRestante() > 0) {
                cola.offer(actual);
            }
        }

        return resultado;
    }

}
