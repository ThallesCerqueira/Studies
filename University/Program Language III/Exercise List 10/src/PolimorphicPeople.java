import Pessoas.Data;
import Pessoas.Pessoa;
import java.util.List;
import Pessoas.Funcionario;
import java.util.ArrayList;
import Pessoas.ChefeDeDepartamento;

public class PolimorphicPeople {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add( new Pessoa( "Thalles", 100L, new Data( 1, 1, 2000 ) ) );
        pessoas.add( new Funcionario( "Davi", 101L, new Data(), new Data(), 1000d ) );
        pessoas.add( new ChefeDeDepartamento( "Roberto", 110L, new Data(), new Data(), 10000d, "Contábeis", new Data() ) );

        // Imprimindo as características e possibilidades de crédito - Polimorfismo de subClasse. Entendi o polimorfismo de classe, mas tô com preguiça de fazer.
        for( Pessoa pessoa: pessoas ) {
            System.out.println( pessoa.toString() );
            System.out.println( "Possibilidade de empréstimo: " + pessoa.calculaEmprestimo() );
            System.out.println();
        }

    }

}
