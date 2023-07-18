import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        // Variáveis
        int opcaoMenu, opcaoMoeda;
        Cofrinho cofre = new Cofrinho();

        System.out.println("Taisy Gomes dos Santos - 4232101");

        System.out.println("COFRINHO DE MOEDAS");

        // Laço para fazer o programa executar por tempo indeterminado
        while (true){

            // Mostrando o menu principal
            menu();
            opcaoMenu = opcao(1,5);

            // Verificando a escolha do usuario
            switch (opcaoMenu){

                // Caso para adicionar moeda
                case 1:
                    menuMoeda();
                    opcaoMoeda = opcao(1,3);

                    if (opcaoMoeda == 1){
                        cofre.adicionar(new Dolar(5));
                    }else if (opcaoMoeda == 2){
                        cofre.adicionar(new Euro(6));
                    }else {
                        cofre.adicionar(new Real(1));

                    }

                    break;

                // Caso para remover moeda
                case 2:
                    menuMoeda();
                    opcaoMoeda = opcao(1,3);

                    if (opcaoMoeda == 1){
                        System.out.println("Valor da moeda removida: " + cofre.remover(new Dolar(5)));
                    }else if (opcaoMoeda == 2){
                        System.out.println("Valor da moeda removida: " + cofre.remover(new Euro(6)));
                    }else {
                        System.out.println("Valor da moeda removida: " + cofre.remover(new Real(1)));

                    }
                    break;

                // Caso para listar moedas
                case 3:
                    cofre.listagemMoedas();
                    break;

                // Caso para total de moedas convertidas
                case 4:
                    System.out.printf("Total de moedas convertidos: %.2f\n",  cofre.totalConvertido());
                    break;

                case 5:
                    exit(1);

            }
        }



    }

    // Método de menu
    public static void menu(){
        System.out.println("1- Adicionar moedas");
        System.out.println("2- Remover moedas");
        System.out.println("3- Listar moedas");
        System.out.println("4- Calcular total de moedas convertidas");
        System.out.println("5- Sair do programa");
    }

    // Método de menu Moeda
    public static void menuMoeda(){
        System.out.println("1- Dólar");
        System.out.println("2- Euro");
        System.out.println("3- Real");
    }

    // Método genérico para pegar opção do usuario.
    public static int opcao(int minimo,int maximo){
        Scanner sc = new Scanner(System.in);
        int valor;
        do{
            System.out.print("\nOpção: ");
            valor = sc.nextInt();

            if (valor<minimo||valor>maximo){
                System.out.println("\nOpção inválida");
            }

        }while (valor<minimo||valor>maximo);

        return valor;

    }

}