package figuras;

public class Triangle extends Shape2D {

    private float lado1;
    private float lado2;
    private float lado3;

    public Triangle( float lado1, float lado2, float lado3 ) {

        super();
        if( validaTriangulo( lado1, lado2, lado3 ) ) {
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }else {
            this.lado1 = 1;
            this.lado2 = 1;
            this.lado3 = 1;
        }

    }

    public Triangle() {
        this( 1.0f, 1.0f, 1.0f );
    }

    public Triangle( Triangle triangle ) {
        this( triangle.lado1, triangle.lado2, triangle.lado3 );
    }

    private boolean validaTriangulo( float lado1, float lado2, float lado3 ) {

        if( lado1 > mod( lado2 - lado3 ) &&  lado1 < ( lado2 + lado3 ) ) {
            return true;
        } else if ( lado2 > mod( lado1 - lado3 ) && lado2 < ( lado1 + lado3 ) ) {
            return true;
        } else return lado3 > mod(lado1 - lado2) && lado3 < (lado1 + lado2);

    }

    private float mod( float a ) {

        if( a< 0 ) {
            return a * (-1);
        }else{
            return a;
        }
    }

    @Override
    public float area() {
        return 
    }

    @Override
    public String toString() {
        return "Lado 1: " + this.lado1 + "Lado 2: " + this.lado2 + "Lado 3: " + this.lado3;
    }

}