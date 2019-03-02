
public class Square extends Rectangle {
    private double length; 
    
    public Square(double x, double y, double length) {
        super(x, y, length, length);
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Square)) { return false; }
        Square f = (Square) o;
        return f.length == length;
    }
    
    public double area() {
        return super.area();
    }
    
    public double perimeter() {
        return super.perimeter();
    }

    public String toString() {
        return "Square:\n\t" +
            super.toString() +
            "\n\tLength: " + length;
    }
    
    /** Practica 2**/
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
    
    public void print(char c) {
        super.print(c);
    }
}
