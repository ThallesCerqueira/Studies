public class Ponto2D {

    private int x;
    private int y;

    public Ponto2D( int x, int y ) {

        this.x = x;
        this.y = y;

    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void imprimirPonto() {

        System.out.println("Ponto (" +x+ ","+ y+")");

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

    public int quadrante(){

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

    public float distancia(int x, int y){

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

}
