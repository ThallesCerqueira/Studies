package Figuras;

public class Square extends Shape2D {

    public Square( float base ) {
        super( 1, base );
    }

    public Square() {
        this( 1.0f );
    }

    public Square( Square square ) {
        this( square.getBase() );
    }

    @Override
    public float area() {
        return super.getBase() * super.getBase();
    }

    @Override
    public String toString() {
        return "Base:  " + super.getBase();
    }

    @Override
    public float perimetro() {
        return 4 * super.getBase();
    }

}