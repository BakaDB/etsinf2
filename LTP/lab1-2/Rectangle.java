
public class Rectangle extends Figure  {
    private double base, height;    
    
    public Rectangle(double x, double y, double h, double b) {
        super(x, y);
        base = h;
        height = b;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) { return false; }
        Rectangle f = (Rectangle) o;
        return f.base == base && f.height == height;
    }
    
    public double area() {
        return base*height;
    }
    
    public double perimeter(){
        return 2 * (base + height);
    }

    public String toString() {
        return "Rectangle:\n\t" +
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
    
    public void print(char c) {
        int b = (int) base;
        int h = (int) height;
        for(int i = 0; i < h; i++){
            for(int j = 0; j< b;j++) System.out.print(c);
            System.out.println();
        }
    }
}
