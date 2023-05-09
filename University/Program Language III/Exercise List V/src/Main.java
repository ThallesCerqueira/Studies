public class Main {

    public static void main(String[] args) {

        //Instanciando os objetos
        Time time = new Time( 30205 );
        Data data = new Data(8, 5, 2023);
        Contato contato = new Contato( "Thalles", "thalles@gmail.com", "73988775544", "01/01/2000" );
        Lampada lampada = new Lampada( 100 );
        Ponto2D ponto2D = new Ponto2D(3, 4);
        Circulo circulo = new Circulo(2, 3, 4);

        //Exemplo para a Time
        System.out.println("===== Exemplo para a Classe Time =====");
        System.out.println( "Estamos na parte da manhã? " + time.isAm() );
        System.out.print( "Que horas são? " );
        time.prnTime();

        System.out.println();

        //Exemplo para a Classe Data
        System.out.println("===== Exemplo para a Classe Data =====");
        System.out.println("Data válida? " + data.verificarData());
        System.out.print("Data: ");
        data.imprimirData();
        System.out.println("isPrevious? " + data.isPrevious( 07, 05, 2023 ));
        System.out.println("howManyDays: " + data.howManyDays( 01, 05, 2023 ));
        System.out.println( "Quantos dias? " + data.dateToDay( 8, 05, 2023 ) );

        System.out.println();

        //Exemplo para a Classe Contato
        System.out.println("===== Exemplo para a Classe Contato =====");
        contato.imprimirContato();

        System.out.println();

        //Exemplo para a Classe Lampada
        System.out.println("===== Exemplo para a Classe Lampada =====");
        System.out.println("Lâmpada ligada? " + lampada.estaLigada() );
        lampada.mostraEstado();

        System.out.println();

        //Exemplo para a Classe Ponto2D
        System.out.println("===== Exemplo para a Classe Ponto2D =====");
        System.out.println("isEixoX? " + ponto2D.isEixoX());
        System.out.println("isEixoY? " + ponto2D.isEixoY());
        System.out.println("isEixos? " + ponto2D.isEixos());
        ponto2D.imprimirPonto();
        System.out.println("Quadrante: " + ponto2D.quadrante());
        System.out.println("Distância entre os pontos: " + ponto2D.distancia(2,3));

        System.out.println();

        //Exemplo para a Classe Circulo
        System.out.println("===== Exemplo para a Classe Circulo =====");
        circulo.imprimirCirculo();
        System.out.println("Circulo válido? " + circulo.validaCirculo() );
        System.out.println("Área do circulo: " + circulo.area() );
        System.out.println("Perimetro do circulo: " + circulo.perimeter() );
        System.out.println( "is Bigger than? " + circulo.isBiggerThan( 1, 2, 3 ) );

    }

}