package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Test de prueba para la implementación de Cola de Prioridad
 * utilizando una ListaConPI ordenada. Verifica los métodos
 * insertar y eliminarMin de la clase LPIColaPrioridad
 * 
 * @version Curso 2017/18
 */
public class TestLPIColaPrioridad {

    public static void main() {
        
        int[] v = {3, 2, 6, 6, 1, 0, 9, 6, 5};
        String sv = "[0, 1, 2, 3, 5, 6, 6, 6, 9]";
        ColaPrioridad<Integer> cp = new LPIColaPrioridad<Integer>();
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