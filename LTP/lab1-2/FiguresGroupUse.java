import java.util.*;
/**
 * class FiguresGroupUse.
 * 
 * @author LTP 
 * @version 2017-18
 */
public class FiguresGroupUse {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        FiguresGroup g = new FiguresGroup();
        g.add(new Circle(10, 5, 3.5));
        g.add(new Triangle(10, 5, 6.5, 32));
        g.add(new Rectangle(0, 3, 5, 40));
        System.out.println(g);        
        System.out.println(g.area());        
      
        /** Practica 2 **/
        List l = new LinkedList();
        Random r = new Random();
        for (int i = 0; i < 100; i++){
            if ( r.nextInt(2) == 0 ) {
                l.add(new Rectangle(1,1,r.nextDouble()*10,r.nextDouble()*10));
            }
            else l.add(new Square(1,1,r.nextDouble()*10));
        }
        for (int i = 0; i < 100; i++){
            Rectangle fi = (Rectangle) l.get(i);
            for (int j = i+1; j < 100; j++){
                Rectangle fj = (Rectangle) l.get(j);
                if(fi.compareToRange(fj) == 0){
                    System.out.print("Figuras iguales: "+fi.getClass().getName()+i+
                        " y "+fj.getClass().getName()+j+
                        "\n Areas: "+fi.area()+", "+fj.area()+"\n");
                }
            }
        }
    }
}