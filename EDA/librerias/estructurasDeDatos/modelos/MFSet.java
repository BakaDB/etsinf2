package librerias.estructurasDeDatos.modelos;

/** Representa las clases -subconjuntos disjuntos- que define una relacion
 *  de equivalencia en un conjunto de cardinal N 
 *** Los elementos del conjunto se representan mediante enteros en el 
 *   intervalo [0, N-1], pues su tipo concreto NO interviene en la defincion 
 *   de las clases
 *   
 *** Los elementos de una clase se representan mediante uno SOLO de sus 
 *   miembros, cualquiera de ellos, pues todos son equivalentes. Este elemento
 *   recibe el nombre de identificador de la clase
 *   
 *** Las clases se definen dinamicamente a partir de las N triviales, 
 *   cada una formada por un elemento del conjunto
 *      
 *  Ademas de Merge-Find Set, otros nombres que recibe este Modelo son 
 *  Estructura de Particion (Disjoint-Set en Ingles) y Union-Find Set
 *  
 *  @author Profesores de EDA 
 *  @version 2018
 */

public interface MFSet {
    
    /** Devuelve el identificador de la clase de equivalencia
     *  -subconjunto- al que pertence el elemento i. */
    int find(int i);
    
    /** Une las clases de equivalencia subconjuntos- a las que pertenecen
     *  los elementos i y j, excepto si i y j ya estan en la misma clase. */
    void merge(int i, int j);
}
