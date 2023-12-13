import java.util.Scanner;

public class Utils {

    public void menuPrincipal() {

        System.out.println( "===== MENU PRINCIPAL =====" );
        System.out.println("Qual tipo de usuário?");
        System.out.println("1 - Administrador");
        System.out.println("2 - Professor");
        System.out.println("3 - Aluno");
        System.out.println("4 - Sair");

    }

    public static int escolha(int min, int max) {

        int opcao;
        Scanner sc = new Scanner( System.in );

        do {
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            if (opcao < min || opcao > max) {
                System.out.println("Opção inválida");
            }
        } while (opcao < min || opcao > max);

        return opcao;

    }

    public void menuPrincAluno() {

        System.out.println("1 - Iniciar um curso");
        System.out.println("2 - Ver meus cursos");
        System.out.println("3 - Fazer avaliação");
        System.out.println("4 - Emitir Certificado");
        System.out.println("5 - Meus dados");
        System.out.println("6 - Voltar");

    }

}
