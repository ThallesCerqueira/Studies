public class Ponto2D {

    private int x;
    private int y;

    public Ponto2D() {
        this( 0, 0 );
    }

    public Ponto2D( int x, int y ) {

        this.x = x;
        this.y = y;

    }

    public Ponto2D( Ponto2D ponto ) {
        this( ponto.x, ponto.y );
    }

    public String toString() {
        return "X: " + this.x + " Y: " + this.y;
    }

    public boolean inAxisX() {
        return this.y == 0;
    }

    public boolean inAxisY() {
        return this.x == 0;
    }

    public boolean inAxis() {
        return (this.x == 0 && this.y == 0) || inAxisX() || inAxisY();
    }

    public boolean isOrigin() {
        return this.x == 0 && this.y == 0;
    }

    public double distance( int x, int y ) {

        int dx = this.x - x;
        int dy = this.y - y;

        return Math.sqrt( dx*dx + dy*dy );
    }

    public double distance( Ponto2D ponto ) {
        return this.distance( ponto.x, ponto.y );
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


}
