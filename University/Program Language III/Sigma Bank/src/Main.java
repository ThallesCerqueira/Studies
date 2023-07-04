import utils.Utils;
import pessoas.Pessoa;
import java.util.Scanner;
import pessoas.Funcionario;
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
        ArrayList<Pessoa> funcionarioList = new ArrayList<>();

        // Chamando método para popular os usuários
        Conta.inicializaContas( contaList );

        // Chamando método para popular os funcionários
        Funcionario.inicializaFuncionarios( funcionarioList );

        System.out.println(" ========= Bem-Vindo ao Sigma Bank ========= ");

        while ( true ) {

            // Mostrando o Menu Principal
            Utils.menuPrincipal();
            escolha = Utils.opcao( 1, 5 );

            // Chamando o método de acordo com a escolha do Usuário
            switch (escolha) {

                // Opção para acessar uma Conta
                case 1 -> contaAtual = Conta.acessarConta( contaList );

                // Opção para criar uma Conta
                case 2 -> contaAtual = Conta.abrirConta( contaList );

                // Opção para mostrar os funcionarios
                case 3 -> {
                    Utils.nossosFuncionarios(funcionarioList);
                    continue;
                }

                // Opção para mostrar os clientes
                case 4 -> {
                    Utils.nossosClientes( contaList );
                    continue;
                }

                // Opção para encerrar o programa
                case 5 -> {
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