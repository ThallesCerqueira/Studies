import java.util.concurrent.ThreadLocalRandom;

public class exampleWhile {
    public static void main(String[] args) {
        
        double mesada = 50.0;

        while(mesada > 0){
            double valorDoce = randomNumber();

            if(valorDoce > mesada){
                valorDoce = mesada;
            }

            System.out.println("Doce do valor: " + valorDoce + " adicionado no carrinho.");
            mesada = mesada - valorDoce;

        }

        System.out.println("mesada: " + mesada);
        System.out.println("Joãozinho gastou toda a sua mesada em doces.");

    }

    private static double randomNumber(){
        return ThreadLocalRandom.current().nextDouble(2,8);
    }
}
