package librerias.estructurasDeDatos.grafos;

/** Clase GrafoNoDirigido: implementacion de un grafo No Dirigido 
 *  (Ponderado o no) mediante Listas de Adyacencia:<br>
 *  un grafo No Dirigido ES UN Grafo Dirigido tal que si la Arista (i, j)  
 *  esta presente en la Lista de Adyacencia de i entonces tambien lo esta
 *  la Arista (j, i) en la de j
 * 
 * @version Mayo 2018
 */

public class GrafoNoDirigido extends GrafoDirigido {
    
    /** Crea un grafo No Dirigido vacio con numV vertices. 
      * 
      * @param numV  Numero de vertices del grafo
     */
    public GrafoNoDirigido(int numV) { 
        super(numV);
        esDirigido = false;
    }
    
    /** Crea un grafo No Dirigido con numV vertices y cuyas
      * aristas son las componentes del array arcos.
      * 
      *  @param numV  Numero de vertices 
      *  @param arcos Array con las aristas del grafo
     */
    public GrafoNoDirigido(int numV, Arista[] arcos) { 
        // COMPLETAR
        super(numV);
        for (int i = 0; i < arcos.length; i++) {
            insertarArista(arcos[i].getOrigen(), arcos[i].getDestino(), arcos[i].getPeso());
        }
        esDirigido = false;
    }
    
    /** Si no esta, inserta la arista (i, j) en un grafo No Dirigido  
      * y No Ponderado; por tanto, tambien inserta la arista (j, i).
      *
      *  @param i    Vertice origen
      *  @param j    Vertice destino
     */ 
    public void insertarArista(int i, int j) {
        insertarArista(i, j, 1);
    }
    
    /** Si no esta, inserta la arista (i, j) de peso p en un grafo  
      * No Dirigido y Ponderado; por tanto, tambien inserta la arista 
      *  (j, i) de peso p.
      *
      * @param i    Vertice origen
      * @param j    Vertice destino
      * @param p    Peso de (i, j)
     */ 
    public void insertarArista(int i, int j, double p) {
        if (!existeArista(i, j)) { 
            elArray[i].insertar(new Adyacente(j, p)); 
            elArray[j].insertar(new Adyacente(i, p));
            numA++; 
        }
    }
}
