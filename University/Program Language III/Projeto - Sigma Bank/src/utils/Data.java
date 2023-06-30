package utils;

public class Data {

    // Atributos da Classe
    private int dia;
    private int mes;
    private int ano;

    // Construtor sem atributos
    public Data() {
        this( 1,1, 1970 );
    }

    // Construtor com 2 atributos
    public Data( int dia, int mes ) {
        this( dia, mes, 1970 );
    }

    // Construtor com 1 atributo
    public Data( int ano ) {
        this( 1, 1, ano );
    }

    // Construtor com 3 atributos
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

    // Método auxiliar para validar os valores
    private boolean validaData( int dia, int mes, int ano ) {
        return dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1970 && ano <= 2050;
    }

    // Sobreescrita do método toString
    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

}