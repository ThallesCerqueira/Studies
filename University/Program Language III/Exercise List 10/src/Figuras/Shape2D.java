package Figuras;

public class Shape2D {

    private float altura;
    private float base;

    public Shape2D() {
        this( 1f, 1f );
    }

    public Shape2D( float altura, float base ) {

        if( validaFigura( altura, base ) ) {
            this.altura = altura;
            this.base = base;
        } else {
            this.altura = 1;
            this.base = 1;
        }

    }

    public Shape2D( Shape2D shape ) {
        this( shape.altura, shape.base );
    }

    public boolean validaFigura( float altura, float base ) {
        return altura >= 0 && base >= 0;
    }

    public float area() {
        return base*altura;
    }

    public float perimetro() {
        return this.base * 4;
    }

    public float getAltura() {
        return this.altura;
    }

    public float getBase() {
        return this.base;
    }

    public void setBase( float base ) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Altura: " + this.altura + "   Base:" + this.base;
    }

}