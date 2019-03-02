import java.util.*;
/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2017-18
 */

public class FiguresGroup{
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;
    
    public void add(Figure f) { 
        if (f instanceof Figure && !found(f)) figuresList[numF++] = f;
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof FiguresGroup)) return false;
        FiguresGroup f = (FiguresGroup) o;
        for (int i = 0; i < numF; i++) {
            if (!found(f.figuresList[i])) return false;
        }
        for (int j = 0; j < numF; j++) {
            if (!f.found(figuresList[j])) return false;
        }
        return true;
    }
    
    public double area() {
        double total = 0;
        for (int i = 0; i < numF; i++) {
            total += figuresList[i].area();
        }
        return total;
    }
    
    public Figure greatestFigure() {
        if (numF == 0) return null;
        Figure f = figuresList[0];
        for (int i = 1; i < numF; i++) {
            if (f.area() < figuresList[i].area()) f = figuresList[i];
        }
        return f;
    }

    private boolean found(Figure f) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i].equals(f)) return true;
        }
        return false;
    }

    private boolean included(FiguresGroup g) {
        for (int i = 0; i < g.numF; i++) {
            if (!found(g.figuresList[i])) return false;
        }
        return true;
    }
    
    /** Practica 2 **/
    @SuppressWarnings("unchecked")
    public Object orderedList() {
        List l = new LinkedList();
        if (numF > 0) {
            for(int i = 0; i < numF; i++) {
                int j = l.size() - 1;
                while (j >= 0 && figuresList[i].compareTo(l.get(j)) < 0) {
                    j--;
                }
                l.add(j+1, figuresList[i]);
            }
        }
        return l;
    }
    
    public void print(char c) {
        for (int i = 0; i < numF; i++) {
            if (!(figuresList[i] instanceof Triangle)) {
                
                if (figuresList[i] instanceof Circle) {
                    Circle aux = (Circle) figuresList[i];
                    aux.print(c);
                }                 
                else if (figuresList[i] instanceof Rectangle) {
                    Rectangle aux = (Rectangle) figuresList[i];
                    aux.print(c);
                }
                else if (figuresList[i] instanceof Square) {
                    Square aux = (Square) figuresList[i];
                    aux.print(c);
                }
            }
            else System.out.println("Unable to draw this figure\n");
        }
    }
    
    public static void main(String a[]){
        FiguresGroup g = new FiguresGroup();
        g.add(new Circle(1.0, 6.0, 6.0));
        g.add(new Rectangle(2.0, 5.0, 10.0, 10.0));
        g.add(new Triangle(3.0, 4.0, 10.0, 2.0));
        g.add(new Circle(4.0, 3.0, 1.0));
        g.add(new Triangle(5.0, 1.0, 1.0, 2.0));
        g.add(new Square(6.0, 7.0, 15));
        g.add(new Rectangle(7.0, 2.0, 1.0, 1.0));
        System.out.println(g.orderedList());
    }    
}