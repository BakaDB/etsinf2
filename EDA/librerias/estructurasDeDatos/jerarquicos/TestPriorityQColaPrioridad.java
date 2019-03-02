package librerias.estructurasDeDatos.jerarquicos;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Test de prueba para la implementación de Cola de Prioridad
 * utilizando una ProrityQueue. Verifica los métodos
 * insertar y eliminarMin de la clase PriorityQColaPrioridad
 * 
 * @version Curso 2017/18
 */
public class TestPriorityQColaPrioridad {

    public static void main() {
        
        int[] v = {3, 2, 6, 6, 1, 0, 9, 6, 5};
        String sv = "[0, 2, 1, 5, 3, 6, 9, 6, 6]";
        ColaPrioridad<Integer> cp = new PriorityQColaPrioridad<Integer>();
        // Comprobando insertar
        System.out.print("Comprobando el método insertar...");
        for (int i = 0; i < v.length; i++) { cp.insertar(v[i]); }
        boolean okInsertar = sv.equals(cp.toString());
        if (okInsertar) { System.out.println("CORRECTO!!"); }
        else {System.out.println("REVISAR EL CODIGO!!!"); }
        
        // Comprobando eliminarMin 
        System.out.print("Comprobando el método eliminarMin...");
        Integer prim = cp.eliminarMin();
        Integer menor = new Integer(0);
        boolean okEliminarMin = menor.equals(prim);
        if (okEliminarMin) { System.out.println("CORRECTO!!"); }
        else {System.out.println("REVISAR EL CODIGO!!!"); }
    }    
}
