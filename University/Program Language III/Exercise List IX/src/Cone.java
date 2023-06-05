public class Cone extends FigurasTridimensionais {

    public Cone( int x, int y, int z, double raio, double altura ) {
        super( x, y, z, raio, altura );
    }

    public Cone() {
        this( 0, 0, 0, 1, 0 );
    }

    public double volume() {
        return ( PI * super.getRaio() * super.getRaio() * super.getAltura() ) / 3;
    }

    public double area() {

        double geratriz = super.getRaio() * super.getRaio() + super.getAltura() * super.getAltura();
        geratriz = Math.sqrt(geratriz );

        return PI * super.getRaio() * ( super.getRaio() + geratriz );
    }
}
