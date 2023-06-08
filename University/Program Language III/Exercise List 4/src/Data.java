public class Data {

    private int dia;
    private int mes;
    private int ano;

    public void inicializarData() {
        this.dia = 1;
        this.mes = 1;
        this.ano = 2000;
    }

    public boolean verificarData() {
        if (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 1999 & ano < 3000){
            return true;
        }else{
            return false;
        }
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
}
