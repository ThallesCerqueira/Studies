package Figuras;

public class Circle extends Shape2D {

    private float raio;
    private final float PI = 3.14f;

    public Circle() {
        this( 1.0f );
    }

    public Circle( float raio ) {
        super( 1.0f, 1.0f );

        if( validaRaio( raio ) ) {
            this.raio = raio;
        }else {
            this.raio = 1.0f;
        }

    }

    public Circle( Circle circle ) {
        this( circle.raio );
    }

    public boolean validaRaio( float raio ) {
        return raio >= 0;
    }

    @Override
    public float area() {
        return PI * this.raio * this.raio;
    }

    @Override
    public String toString() {
        return "Raio: " + raio + "   Pi: " + PI;
    }

    @Override
    public float perimetro() {
        return 2 * PI * this.raio;
    }

}
