

//Clase Generado PID
package util;

public class GeneradorPID {
    private int contador;

    public GeneradorPID() {
        this.contador = 1;
    }

    public String generar() {
        return String.format("P%03d", contador++);
    }
}