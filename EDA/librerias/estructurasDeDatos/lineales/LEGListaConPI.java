package librerias.estructurasDeDatos.lineales;
import librerias.estructurasDeDatos.modelos.ListaConPI;

/**
 * Write a description of class LEGListaConPi here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LEGListaConPI<E> implements ListaConPI<E> {
    
    protected NodoLEG<E> pri, ult, ant;
    
    protected int talla;
    
    public LEGListaConPI() {
        pri = ult = ant = new NodoLEG<E>(null);
        talla = 0;
    }
    
    public void insertar(E e) {
        NodoLEG<E> nuevo = new NodoLEG<E>(e);
        talla++;
        nuevo.siguiente = ant.siguiente;
        ant.siguiente = nuevo;
        if (ant == ult) ult = ant.siguiente;
        ant = nuevo;
    }
    
    public void eliminar() {
        talla--;
        if (ant.siguiente == ult) ult = ant;
        ant.siguiente = ant.siguiente.siguiente;
    }
    
    public void inicio() {
        if (!esVacia()) ant = pri;
    }
    
    public void siguiente() {
        if (!esFin()) ant = ant.siguiente;
    }
    
    public void fin() {
        ant = ult;
    }    
    
    public boolean esFin() {
        return ant == ult;
    }
    
    public E recuperar() {
        return ant.siguiente.dato;
    }
    
    public boolean esVacia() {
        return pri == ult;
    }
    
    public int talla() {
        return talla;
    }
    
    public String toString() {
        // NOTA: se usa la clase StringBuilder, en lugar de String,
        // por motivos de eficiencia
        StringBuilder s = new StringBuilder();
        s.append("[");
        NodoLEG<E> aux = pri.siguiente;
        for (int i = 1; i < talla; i++, aux = aux.siguiente) {
            s.append(aux.dato.toString());
            s.append(", ");
        }
        if (talla != 0) {
            s.append(aux.dato.toString());
            s.append("]");
        } else { s.append("]"); }
        return s.toString();
    }
}