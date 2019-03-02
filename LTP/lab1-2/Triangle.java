
/**
 * class Triangle.
 * 
 * @author LTP
 * @version 2017-18
 */

public class Triangle extends Figure {
    private double base; 
    private double height;

    public Triangle(double x, double y, double b, double h) {
        super(x, y);
        base = b;
        height = h;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Triangle)) { return false; }
        Triangle f = (Triangle) o;
        return base == f.base && height == f.height;
    }
    
    public double area() {
        return (base*height)/2;
    }
    
    public double perimeter() {
        System.err.println("Not enough information to calculate the perimeter of this triangle D:");
        return -1;
    }
    
    public String toString() {
        return "Triangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }
    
    /** Practica 2 **/
    public int compareTo(Object o) {
        if (!(o instanceof Figure)) throw new ClassCastException();
        Figure aux = (Figure) o;
        if (this.area() == aux.area()) return 0;
        else if (this.area() < aux.area()) return -1;
        else return 1;
    }
}