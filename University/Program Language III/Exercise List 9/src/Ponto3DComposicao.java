public class Ponto3DComposicao {

    private int z;
    private Ponto2D ponto2D;

    public Ponto3DComposicao() {
        this( 0, 0, 0 );
    }

    public Ponto3DComposicao( int x, int y, int z ) {
        this.ponto2D = new Ponto2D( x, y );
        this.z = z;
    }

    public Ponto3DComposicao( Ponto3DComposicao ponto ) {
        this( ponto.ponto2D.getX(), ponto.ponto2D.getY(), ponto.z );
    }

    public String toString() {
        return ponto2D.toString() + "\nZ: " + this.z;
    }

    public boolean inAxisX() {
        return ponto2D.inAxisX() && this.z == 0;
    }

    public boolean inAxisY() {
        return ponto2D.inAxisY() && this.z == 0 ;
    }

    public boolean inAxisZ() {
        return ponto2D.inAxis();
    }

    public boolean inAxis() {
        return ponto2D.inAxis() && this.z == 0 ;
    }

    public boolean isOrigin() {
        return ponto2D.isOrigin() && this.z == 0;
    }

    public double distance( int x, int y, int z ) {
        int dx = ponto2D.getX() - x;
        int dy = ponto2D.getY() - y;
        int dz = this.z - z;

        return Math.sqrt( dx*dx + dy*dy + dz*dz );
    }

    public double distance( Ponto3DComposicao ponto ) {
        return this.distance( ponto.ponto2D.getX(), ponto.ponto2D.getY(), ponto.z );
    }

}
