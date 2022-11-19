package calculadora;

public class calculadora {
    public static void soma(double num1, double num2){
        double resultado = num1 + num2;
        System.out.println("A soma de " + num1 + "+" + num2 + "é: "+ resultado);
    }

    public static void subtrair(double num1, double num2){
        double resultado = num1 - num2;
        System.out.println("A subtração de " + num1 + "+" + num2 + "é: "+ resultado);
    }

    public static void multiplicar(double num1, double num2){
        double resultado = num1 * num2;
        System.out.println("A multiplicação de " + num1 + "+" + num2 + "é: "+ resultado);
    }

    public static void dividir(double num1, double num2){
        double resultado = num1 / num2;
        System.out.println("A divisão    de " + num1 + "+" + num2 + "é: "+ resultado);
    }
}
