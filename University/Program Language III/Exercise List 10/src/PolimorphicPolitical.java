import Pessoas.Data;
import java.util.List;
import Pessoas.Politico;
import Pessoas.Prefeito;
import Pessoas.Governador;
import java.util.ArrayList;

public class PolimorphicPolitical {

    public static void main(String[] args) {

        List<Politico> politicoList = new ArrayList<>();
        politicoList.add( new Politico( "Fulano", 1, new Data(), "ABC", 123 ) );
        politicoList.add( new Prefeito( "Ciclano", 10, new Data(), "CBA", 321, "Cidade do Nunca" ) );
        politicoList.add( new Governador( "Beltrano", 11, new Data(), "BCA", 231, "New State" ) );

        //Imprindo características
        for( Politico politico: politicoList ) {
            System.out.println( politico.toString() );
            System.out.println();
        }

    }

}
