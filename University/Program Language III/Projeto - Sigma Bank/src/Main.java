import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.exit;
import produtosBancarios.contas.Conta;
import utils.ClasseUtils;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Variáveis
        int escolha = 0;
        Conta contaAtual = null;
        ArrayList<Conta> contaList = new ArrayList<>();
        Conta.inicializaContas(contaList);

        System.out.println(" ========= Bem-Vindo ao Sigma Bank ========= ");

        while ( true ) {

            // Verificando a opção do Usuário
            do {
                ClasseUtils.menuPrincipal();
                escolha = sc.nextInt();

                if (escolha < 1 || escolha > 3) System.out.println("Opção inválida.");

            } while (escolha < 1 || escolha > 3);

            switch (escolha) {
                case 1 -> contaAtual = Conta.acessarConta(contaList);
                case 2 -> contaAtual = Conta.abrirConta(contaList);
                case 3 -> {
                    System.out.println( "\nEncerrando Programa!" );
                    System.out.println( "Contas instanciadas: " + Conta.getQtdContas() );
                    exit( 0 );
                }
            }

            if (contaAtual != null) {
                contaAtual.acoesConta();
            } else {
                System.out.println("\nConta não localizada. Tente novamente!");
            }

        }

    }

}