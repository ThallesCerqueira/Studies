import utils.Utils;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.exit;
import produtosBancarios.contas.Conta;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Variáveis
        int escolha = 0;
        Conta contaAtual = null;
        ArrayList<Conta> contaList = new ArrayList<>();

        // Chamando método para popular os usuários
        Conta.inicializaContas(contaList);

        System.out.println(" ========= Bem-Vindo ao Sigma Bank ========= ");

        while ( true ) {

            // Mostrando o Menu Principal
            Utils.menuPrincipal();
            escolha = Utils.opcao( 1, 3 );

            // Chamando o método de acordo com a escolha do Usuário
            switch (escolha) {

                // Opção para acessar uma Conta
                case 1 -> contaAtual = Conta.acessarConta(contaList);

                // Opção para criar uma Conta
                case 2 -> contaAtual = Conta.abrirConta(contaList);

                // Opção para encerrar o programa
                case 3 -> {
                    System.out.println( "\nEncerrando Programa!" );
                    System.out.println( "Contas instanciadas: " + Conta.getQtdContas() );
                    exit( 0 );
                }
            }

            // Verificando se foi possível encontrar ou criar a Conta
            if (contaAtual != null) {

                contaAtual.acoesConta();

            } else {
                System.out.println("\nConta não localizada. Tente novamente!");
            }

        }

    }

}