import Pessoas.Data;
import Agenda.Pessoa;
import java.util.List;
import Agenda.PessoaFisica;
import java.util.ArrayList;
import Agenda.PessoaJuridica;

public class PolimorphicCpfCnpj {

    public static void main(String[] args) {

        long chave;
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add( new Pessoa( "Thalles", "Rua sem saída", 36325749, "tcsantos.cic@uesc.br" ) );
        pessoaList.add( new PessoaFisica( "Thalles", 123456789, "Rua sem saída", new Data(), 36325749, "tcsantos.cic@uesc.br"  ) );
        pessoaList.add( new PessoaJuridica( "Organização Tabajara", 987654321, "Rua de lima", 1000000, 36324213, "tabajara@gmail.com" ) );


        System.out.println( "Pessoas cadastradas:" );
        imprimePessoas( pessoaList );

        System.out.println( "=====================================================" );

        chave = 123456789;
        //chave = 987654321;
        System.out.println( "Pessoa encontrada: " + buscaPessoa( pessoaList, chave ) );

    }

    private static void imprimePessoas( List<Pessoa> pessoaList ) {
        for( Pessoa pessoa: pessoaList ) {
            System.out.println( pessoa.toString() );
            System.out.println();
        }
    }

    private static String buscaPessoa( List<Pessoa> pessoaList, long chave ) {

        for( Pessoa pessoa: pessoaList ) {
            if( pessoa.getChave() == chave ) {
                return pessoa.toString();
            }
        }

        return null;
    }

}