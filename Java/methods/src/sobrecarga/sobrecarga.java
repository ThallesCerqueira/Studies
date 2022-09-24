package sobrecarga;

public class sobrecarga {
    public static void area(int lado){
        int ladoQuadrado = lado * lado;
        System.out.println("A área do quadrado é: " + ladoQuadrado);
    }

    public static void area(int lado1, int lado2) {
        int areaQuadrado = lado1 * lado2;
        System.out.println("A área do quadrado é: " + areaQuadrado);

    }

    public static void area(int baseMaior, int baseMenor, int altura){
        float areaTrapezio = ((baseMaior + baseMaior) * altura) / 2;
        System.out.println("A área do trapézio é: " + areaTrapezio);
    }

    public static void area(int dMaior, float dMenor){
        float areaLosango = dMaior*dMenor/2;
        System.out.println("A área do losango é: " + areaLosango);

    }
}
