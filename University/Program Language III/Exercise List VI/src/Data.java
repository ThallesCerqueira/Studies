public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data( int dia, int mes, int ano ) {

        if( validaData(dia, mes, ano) ) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1970;
        }

    }

    public Data() {

        this.dia = 1;
        this.mes = 1;
        this.ano = 1970;

    }

    public Data( Data objeto ) {

        if( validaData( objeto.dia, objeto.mes, objeto.ano ) ) {
            this.dia = objeto.dia;
            this.mes = objeto.mes;
            this.ano = objeto.ano;
        }else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1970;
        }

    }

    public boolean verificarData() {
        if (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 1999 & ano < 3000){
            return true;
        }else{
            return false;
        }
    }

    private boolean validaData( int dia, int mes, int ano ) {

        if( ano < 1970 || ano > 2050 ){
            return false;
        } else if ( dia < 1 || dia > 31 || mes < 1 || mes > 12 ) {
            return false;
        }

        return true;

    }

    public int getDia() { return dia; }

    public void setDia( int dia ) {
        if(dia > 0 && dia < 32){
            this.dia = dia;
        }else{
            this.dia = 1;
        }
    }

    public int getMes() { return mes; }

    public void setMes(int mes) {
        if (mes > 0 && mes < 13) {
            this.mes = mes;
        }else{
            this.mes = 1;
        }
    }

    public int getAno() { return ano; }

    public void setAno(int ano) {
        if(ano > 1999 & ano < 3000 ){
            this.ano = ano;
        }else{
            ano = 2000;
        }
    }

    public void imprimirData() { System.out.println( dia + "/" + mes + "/" + ano ); }

    public void imprimirDataExtenso() {
        System.out.print( dia + " de ");

        if(mes == 1){
            System.out.print("Janeiro ");
        } else if (mes == 2) {
            System.out.print("Fevereiro ");
        } else if (mes == 3) {
            System.out.print("Março ");
        }else if (mes == 4){
            System.out.print("Abril ");
        }else if (mes == 5){
            System.out.print("Maio ");
        }else if (mes == 6){
            System.out.print("Junho ");
        }else if (mes == 7){
            System.out.print("Julho ");
        }else if (mes == 8){
            System.out.print("Agosto ");
        }else if (mes == 9){
            System.out.print("Setembro ");
        }else if (mes == 10){
            System.out.print("Outubro ");
        }else if (mes == 11){
            System.out.print("Novembro ");
        }else {
            System.out.print("Dezembro ");
        }

        System.out.println("de " + ano + ".");

    }

    public boolean isPrevious( int dia, int mes, int ano ) {

        if (dateToDay(dia, mes, ano ) < dateToDay(this.dia, this.mes, this.ano)) {
            return true;
        }

        return false;
    }

    int howManyDays( Data objeto ) {

        int parametro = dateToDay( objeto.dia, objeto.mes, objeto.ano );
        int atributo = dateToDay( this.dia, this.mes, this.ano );
        int percorridos = atributo - parametro;

        if( percorridos >= 0 ) {
            return percorridos;
        }

        return 0;

    }

    int howManyDays( int dia, int mes, int ano ) {

        int parametro = dateToDay(dia, mes, ano );
        int atributo = dateToDay(this.dia, this.mes, this.ano);

        int percorridos = parametro - atributo;

        if( percorridos >= 0 ) {
            return percorridos;
        }

        return 0;

    }

    public int dateToDay( int dia, int mes, int ano ) {

        int resultado;

        resultado = ano * 12 * 30; // Quantidade aproximada de dias

        resultado  += mes * 30; //Quantidade aproximada de dias

        resultado += dia;

        return resultado;

    }

    public void setData( Data novaData ) {

        setData(novaData.dia, novaData.mes, novaData.ano);

    }

    public void setData( int dia, int mes, int ano ) {

        if( validaData(dia, mes, ano) ) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1970;
        }

    }

    public void setData( int daquiAxDias ) {

        this.dia += daquiAxDias;
        this.mes = 1;
        this.ano = 1970;

        if ( this.dia > 31 ) {
            this.mes += 1;

            if ( this.mes > 12 ) {
                this.ano += 1;
            }

        }

    }

    //Falta
    //public SetData(int primeiroDiaDoMesX)
    //public SetData(int primeiraSegundaFeiraDoMesX)
}
