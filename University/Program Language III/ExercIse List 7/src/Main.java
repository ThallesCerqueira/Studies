public class Main {

    public static void main(String[] args) {

        Contato contato1 = new Contato( "Fulano" );
        Contato contato2 = new Contato( "Beltrano" );
        Contato contato3 = new Contato( "Ciclano" );
        Time hora1 = new Time( 13, 51, 10 );
        Time hora2 = new Time( 15, 23, 34 );
        Time hora = new Time();
        Time manha = new Time( 8, 28, 31 );
        Time tarde = new Time( 15, 53, 12 );
        Data data1 = new Data( 29, 5, 2023 );
        Ponto2D ponto1 = new Ponto2D( 2, 3 );
        Ponto2D ponto2 = new Ponto2D( 5, 7 );

        //Exemplo para a Classe Contato
        System.out.println( "=== Exemplo para a Classe Contato ===" );
        contato1.mostraContador();

        //Exemplo para a Classe Time
        System.out.println( "\n=== Exemplo para a Classe Time ===" );
        hora = Time.diffTime( hora1, hora2 );
        System.out.print( "Diferença entre " );
        hora1.prnTime();
        System.out.print( " e " );
        hora2.prnTime();
        System.out.print( " é de " );
        hora.prnTime();

        System.out.print("\nDiferença entre a hora do computador e ");
        hora1.prnTime();
        System.out.print(" é de ");
        hora = Time.diffTime( hora1 );
        hora.prnTime();

        System.out.println();
        manha.prnTime();
        System.out.println( " é de manhã? " + Time.isAm( manha ) );
        tarde.prnTime();
        System.out.println( " é de tarde? " + Time.isPm( tarde ) );


        //Exemplo para a classe Data
        System.out.println();
        System.out.println( "=== Exemplo para a classe Data ===" );
        System.out.println( "29.05.2023 - Quantos dias até o fim do ano ? " + Data.howManyDaysUntilEndYear( data1 ) + " (Arredondado)" );
        System.out.println( "29.05.2023 - Quantos dias até o próximo mês ? " + Data.howManyDaysUntilNextMonth( data1 ) );
        System.out.println( "29.05.2023 - É ano bisexto? " + Data.isBisexto( data1 ) );

        System.out.println( "Data formatada: " + Data.dayToPrintShort( data1 ) );
        System.out.println( "Data Longa: " + Data.dayToPrintLong( data1 ) );


        //Exemplo para a classe Ponto2D
        System.out.println( "\n=== Exemplo para a classe Ponto2D ===" );
        System.out.print( "Distância entre " );
        ponto1.imprimirPonto();
        System.out.print( " e " );
        ponto2.imprimirPonto();
        System.out.print( " é: " + Ponto2D.distance( ponto1, ponto2 ) );

        System.out.print( "\nDistância entre o " );
        ponto1.imprimirPonto();
        System.out.println( " e a origem (0, 0) é: " + Ponto2D.distance( ponto1 ) );

        System.out.print( "O quadrante do " );
        ponto1.imprimirPonto();
        System.out.println( " é: " + Ponto2D.quadrant( ponto1 ) );


        //Exemplo para a biblioteca Grama
        System.out.println( "\n=== Exemplo para a biblioteca Grama ===" );
        System.out.println( "1000 Gramas em Decigramas é: " + Gramas.gramaToDecigrama( 1000 ) );
        System.out.println( "1000 Gramas em Centigramas é: " + Gramas.gramaToCentigrama( 1000 ) );
        System.out.println( "1000 Gramas em Miligramas é: " + Gramas.gramaToMiligrama( 1000 ) );
        System.out.println( "1000 Gramas em Decagramas é: " + Gramas.gramaToDecagrama( 1000 ) );
        System.out.println( "1000 Gramas em Hectogramas é: " + Gramas.gramaToHectograma( 1000 ) );
        System.out.println( "1000 Gramas em Quilogramas é: " + Gramas.gramaToQuilograma( 1000 ) );

        //Exemplo para a biblioteca Quiligrama
        System.out.println( "\n=== Exemplo para a biblioteca Quilograma ===" );
        System.out.println( "2 Quilogramas em Hectogramas é: " + Quilograma.quilogramaToHectograma( 2 ) );
        System.out.println( "2 Quilogramas em Decagramas é: " + Quilograma.quilogramaToDecagrama( 2 ) );
        System.out.println( "2 Quilogramas em Gramas é: " + Quilograma.quilogramaToGramas( 2 ));
        System.out.println( "2 Quilogramas em Decigramas é: " + Quilograma.quilogramaToDecigrama( 2 ) );
        System.out.println( "2 Quilogramas em Centigramas é: " + Quilograma.quilogramaToCentigrama( 2 ) );
        System.out.println( "2 Quilogramas em Miligramas é: " + Quilograma.quilogramaToMiligrama( 2 ) );

        //As outras bibliotecas eu não implementei.

    }
}