public class Ponto2D {

    private int x;
    private int y;

    public Ponto2D(int x, int y ) {

        this.x = x;
        this.y = y;

    }

    public Ponto2D() {
        this.x = 0;
        this.y = 0;

    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void imprimirPonto() {

        System.out.print("Ponto (" +x+ ","+ y+")");

    }

    public boolean isEixoX(){
        if( y == 0 ) return true;

        return false;
    }

    public boolean isEixoY(){
        if(x == 0) return true;

        return false;

    }

    public boolean isEixos(){
        if( isEixoX() || isEixoY() ) return true;

        return false;
    }

    public int quadrante( int x, int y ){

        if(x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        }

        return 0;
    }

    public float distancia( int x, int y ){

        int resultadoX, resultadoY, resultadoXQuadrado, resultadoYQuadrado, somaQuadrados;
        double resultadoRaiz;

        resultadoX = this.x - x;
        resultadoXQuadrado = resultadoX * resultadoX;

        resultadoY = this.y - y;
        resultadoYQuadrado = resultadoY * resultadoY;

        somaQuadrados = resultadoXQuadrado + resultadoYQuadrado;

        resultadoRaiz = Math.sqrt(somaQuadrados);

        return (float)resultadoRaiz;

    }

    public float distancia() {
        return distancia( 0, 0 );
    }

    public float distancia( Ponto2D ponto ) {

        return distancia( ponto.x, ponto.y );

    }

    //DATA 19.05 Como não entendi bem o enunciado da questão irei somente implementar os métodos

    public static float distance( Ponto2D p1, Ponto2D p2 ) {

        int resultadoX, resultadoY, resultadoXQuadrado, resultadoYQuadrado, somaQuadrados;
        double resultadoRaiz;

        resultadoX = p1.x - p2.x;
        resultadoXQuadrado = resultadoX * resultadoX;

        resultadoY = p1.y - p2.y;
        resultadoYQuadrado = resultadoY * resultadoY;

        somaQuadrados = resultadoXQuadrado + resultadoYQuadrado;

        resultadoRaiz = Math.sqrt(somaQuadrados);

        return (float)resultadoRaiz;

    }

    public static float distance( Ponto2D ponto ) {

        Ponto2D aux = new Ponto2D(0,0);

        return distance( ponto,  aux);

    }

    public static int quadrant( Ponto2D ponto ) {

        return ponto.quadrante( ponto.x, ponto.y );

    }

}
