
package modelo;

public class Proceso {
    private final String pid;
    private final String nombre;
    private final int tiempoLlegada;
    private final int tiempoEjecucion;
    private final int quantun;
    private String estado; // "Listo", "Ejecutando", "Terminado"
    private int tiempoRestante;
    private int tiempoFinalizacion;

    // Constructor
    public Proceso(String pid, String nombre, int tiempoLlegada, int tiempoEjecucion, int quantun) {
        this.pid = pid;
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEjecucion = tiempoEjecucion;
        this.quantun = quantun;
        
        
        this.estado = "Listo";
        this.tiempoRestante = tiempoEjecucion;
        this.tiempoFinalizacion = 0;
    }

    // Validación de atributos
    public boolean validar() {
        if (nombre == null || nombre.trim().isEmpty()) return false;
        if (tiempoLlegada < 0 || tiempoEjecucion <= 0 || quantun <= 0) return false;
        return true;
    }

    // Getters
    public String getPid() { return pid; }
    public String getNombre() { return nombre; }
    public int getTiempoLlegada() { return tiempoLlegada; }
    public int getTiempoEjecucion() { return tiempoEjecucion; }
    public int getQuantun() { return quantun; }
    
    
    public void ejecutarUnCiclo() {
    if (tiempoRestante > 0) {
        tiempoRestante--;
        estado = "Ejecutando";
        if (tiempoRestante == 0) {
            estado = "Terminado";
        }
    }
}
    public void reiniciar() {
    this.estado = "Listo";
    this.tiempoRestante = tiempoEjecucion;
    this.tiempoFinalizacion = 0;
}
    public boolean isTerminado() {
    return "Terminado".equals(estado);
}

public String getEstado() {
    return estado;
}

public int getTiempoRestante() {
    return tiempoRestante;
}

public void setTiempoFinalizacion(int tiempo) {
    this.tiempoFinalizacion = tiempo;
}


public int getTiempoFinalizacion() {
    return tiempoFinalizacion;
}

    
    // Representación textual
    @Override
    public String toString() {
        return String.format("PID: %s | Nombre: %s | Llegada: %d | Ejecución: %d | Quantun: %d",
                pid, nombre, tiempoLlegada, tiempoEjecucion, quantun);
    }
    
    public Object[] toArray() {
        return new Object[] {
            pid,
            nombre,
            tiempoLlegada,
            tiempoEjecucion,
            quantun,
            estado,
            tiempoRestante,
            tiempoFinalizacion
        };
    }
}