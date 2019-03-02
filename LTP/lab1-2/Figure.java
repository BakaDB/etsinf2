
/**
 * class Figure.
 * 
 * @author LTP 
 * @version 2017-18
 */

public abstract class Figure {
    protected double x, y;
    
    public Figure(double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Figure)) { return false; }
        Figure f = (Figure) o;
        return x == f.x && y == f.y;
    }
    
    public abstract double area();
    
    public abstract double perimeter();
    
    public String toString() {
        return "Position: (" + x + ", " + y + ")"; 
    }
    
    /**Practice 2**/
    public abstract int compareTo(Object o);
}