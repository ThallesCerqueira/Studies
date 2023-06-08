public class Cilindro extends FigurasTridimensionais {

    public Cilindro( int x, int y, int z, double raio, double altura ) {
        super( x, y, z, raio, altura );
    }

    public Cilindro() {
        this( 0, 0, 0, 1, 0 );
    }

    public String toString() {
        return "X: " + super.getX() + "\nY: " + super.getY() + "\nZ: " + super.getZ() + "\nRaio: " + super.getRaio() +
                "\nAltura: " + super.getAltura();
    }

    public double volume() {
        return PI * (super.getRaio() * super.getRaio() * super.getRaio() ) * super.getAltura();
    }

    public double area() {
        return 2 * PI * super.getRaio() * ( super.getRaio() + super.getAltura() );
    }

}