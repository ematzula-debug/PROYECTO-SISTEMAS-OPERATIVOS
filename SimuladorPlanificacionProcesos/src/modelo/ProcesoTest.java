package  modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProcesoTest {

    @Test
    public void testProcesoValido() {
        Proceso p = new Proceso("P001", "Proceso A", 0, 5, 2);
        assertTrue(p.validar());
    }

    @Test
    public void testNombreVacio() {
        Proceso p = new Proceso("P002", "", 0, 5, 2);
        assertFalse(p.validar());
    }

    @Test
    public void testTiempoNegativo() {
        Proceso p = new Proceso("P003", "Proceso B", -1, 5, 2);
        assertFalse(p.validar());
    }

    @Test
    public void testTiempoEjecucionCero() {
        Proceso p = new Proceso("P004", "Proceso C", 0, 0, 2);
        assertFalse(p.validar());
    }

    @Test
    public void testQuantunNegativo() {
        Proceso p = new Proceso("P005", "Proceso D", 0, 5, -1);
        assertFalse(p.validar());
    }

    @Test
    public void testToString() {
        Proceso p = new Proceso("P006", "Proceso E", 1, 3, 2);
        String esperado = "PID: P006 | Nombre: Proceso E | Llegada: 1 | Ejecución: 3 | Quantun: 2";
        assertEquals(esperado, p.toString());
    }

    @Test
    public void testToArray() {
        Proceso p = new Proceso("P007", "Proceso F", 2, 4, 2);
        Object[] esperado = {"P007", "Proceso F", 2, 4, 2};
        assertArrayEquals(esperado, p.toArray());
    }
}