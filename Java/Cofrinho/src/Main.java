import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        int opcaoMenu, opcaoMoeda;
        Cofrinho cofre = new Cofrinho();

        System.out.println("Taisy Gomes dos Santos - 4232101");

        System.out.println("COFRINHO DE MOEDAS");

        while (true){

            menu();
            opcaoMenu = opcao(1,5);

            switch (opcaoMenu){
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

                case 3:
                    cofre.listagemMoedas();
                    break;

                case 4:
                    System.out.printf("Total de moedas convertidos: %.2f\n",  cofre.totalConvertido());
                    break;

                case 5:
                    exit(1);

            }
        }



    }

    public static void menu(){
        System.out.println("1- Adicionar moedas");
        System.out.println("2- Remover moedas");
        System.out.println("3- Listar moedas");
        System.out.println("4- Calcular total de moedas convertidas");
        System.out.println("5- Sair do programa");
    }

    public static void menuMoeda(){
        System.out.println("1- Dólar");
        System.out.println("2- Euro");
        System.out.println("3- Real");
    }

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