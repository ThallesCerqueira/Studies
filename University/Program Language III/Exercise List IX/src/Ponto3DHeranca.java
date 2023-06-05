public class Ponto3DHeranca extends Ponto2D {

    private int z;

    public Ponto3DHeranca() {
        this( 0, 0, 0 );
    }

    public Ponto3DHeranca( int x, int y, int z ) {

        super( x, y );
        this.z = z;

    }

    public Ponto3DHeranca( Ponto3DHeranca ponto ) {
        this( ponto.getX(), ponto.getY(), ponto.z);
    }

    @Override
    public String toString() {
        return "X: " + super.getX() + " Y: " + super.getY() + " Z: " + this.z;
    }

    @Override
    public boolean inAxisX() {
        return super.getY() == 0 && this.z == 0;
    }

    @Override
    public boolean inAxisY() {
        return super.getX() == 0 && this.z == 0;
    }

    public boolean inAxisZ() {
        return super.getX() == 0 && super.getY() == 0;
    }

    @Override
    public boolean inAxis() {
        return super.getX() == 0 && super.getY() == 0 && this.z == 0;
    }

    @Override
    public boolean isOrigin() {
        return super.getX() == 0 && super.getY() == 0  && this.z == 0;
    }

    public double distance( int x, int y, int z ) {

        int dx = super.getX() - x;
        int dy = super.getY() - y;
        int dz = this.z - z;

        return Math.sqrt( dx*dx + dy*dy + dz*dz );

    }

    public double distance( Ponto3DHeranca ponto ) {
        return this.distance( ponto.getX(), ponto.getY(), ponto.z );
    }

    public int getZ() {
        return z;
    }
}
