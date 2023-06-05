public class FigurasTridimensionais extends Ponto3DHeranca {

    private double raio;
    private double altura;
    public static final double PI = 3.1415;

    public FigurasTridimensionais(int x, int y, int z, double raio, double altura ) {
        super( x, y, z );

        if( validaFigura( raio, altura ) ) {
            this.raio = raio;
            this.altura = altura;
        }else{
            this.raio = 1;
            this.altura = 0;
        }
    }

    private boolean validaFigura(double raio, double altura) {
        return raio >= 0 && altura >= 0;
    }

    public FigurasTridimensionais() {
        this( 0, 0, 0, 1, 0 );
    }

    public double getRaio() {
        return this.raio;
    }

    public double getAltura() {
        return this.altura;
    }
}
