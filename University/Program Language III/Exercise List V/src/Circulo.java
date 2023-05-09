public class Circulo {

    private int x;
    private int y;
    private int raio;

    public Circulo(int x, int y, int raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;

    }

    public boolean validaCirculo() {

        if(raio >= 0) return true;

        return false;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public void imprimirCirculo() {

        System.out.println("X: " + this.x + " Y: " + this.y + " Raio: " + this.raio);
    }

    public boolean isInnerPoint( Ponto2D ponto ){

        //Não implementado

        return true;
    }

    public float area() {

        return (3.14f * (this.raio * this.raio));

    }

    public float perimeter() {

        return 2 * 3.14f * this.raio;
    }

    public boolean isBiggerThan( int x, int y, int raio ) {

        float areaParametro;

        areaParametro = 3.14f * (raio * raio);

        if( area() > areaParametro ) {
            return true;
        }

        return false;
    }
}
