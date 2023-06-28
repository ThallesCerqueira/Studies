package utils;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data() {
        this( 1,1, 1970 );
    }

    public Data( int dia, int mes ) {
        this( dia, mes, 1970 );
    }

    public Data( int ano ) {
        this( 1, 1, ano );
    }

    public Data( int dia, int mes, int ano ) {

        if( validaData( dia, mes, ano ) ) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1970;
        }

    }

    private boolean validaData( int dia, int mes, int ano ) {
        return dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1970 && ano <= 2050;
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

}