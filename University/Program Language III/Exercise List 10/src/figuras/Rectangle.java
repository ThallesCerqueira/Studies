package figuras;

public class Rectangle extends Shape2D {

    public Rectangle( float altura, float base ) {
        super( altura, base );
    }

    public Rectangle() {
        this( 1.0f, 1.0f );
    }

    public Rectangle( Rectangle rectangle ) {
        this( rectangle.getAltura(), rectangle.getBase() );
    }

    @Override
    public float area() {
        return super.getAltura() * super.getBase();
    }

}