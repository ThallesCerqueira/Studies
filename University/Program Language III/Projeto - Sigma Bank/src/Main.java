import produtosBancarios.contas.Conta;
import produtosBancarios.contas.ContaCorrente;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    static Scanner sc = new Scanner( System.in );

    public static void main(String[] args)  {

        // Variáveis
        int escolha = 0;
        Conta contaAtual = null;
        ArrayList<Conta> contaList = new ArrayList<>();
        Conta.inicializaContas( contaList );

        System.out.println(" ========= Bem-Vindo ao Sigma Bank ========= ");

        while( escolha != 5 ) {

            // Verificando a opção do Usuário
            do {
                menuPrincipal();
                escolha = sc.nextInt();

                if( escolha < 1 || escolha > 6 ) System.out.println( "Opção inválida." );

            } while ( escolha < 1 || escolha > 6);

            switch (escolha) {
                case 1 -> contaAtual = Conta.acessarConta(contaList);
                case 2 -> contaAtual = abrirConta();
                case 3 -> {
                    exit(0);
                }
            }

            if( contaAtual != null ) {
                contaAtual.acoesConta();
            } else {
                System.out.println( "\nConta não localizada. Tente novamente!" );
            }

        }

    }

    public static void menuPrincipal() {

        System.out.println( "\n1 - Acessar conta." );
        System.out.println( "2 - Abrir conta." );
        System.out.println( "3 - Encerrar Programa." );
        System.out.print("\nOpção: ");

    }

    private static Conta abrirConta() {
        return null;
    }
}

