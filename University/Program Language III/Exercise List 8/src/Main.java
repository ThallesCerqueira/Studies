public class Main {
    public static void main(String[] args) {

        Data data = new Data();
        Time hora = new Time();

        DataHoraComposicao composicao = new DataHoraComposicao();
        DataHoraAgregacao agregacao = new DataHoraAgregacao( data, hora );


        System.out.println( "Composição:" );
        composicao.toString();

        System.out.println( "\nAgregação:" );
        agregacao.toString();


    }
}