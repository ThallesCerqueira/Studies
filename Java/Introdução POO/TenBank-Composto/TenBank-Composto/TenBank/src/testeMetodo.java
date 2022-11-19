import javax.print.event.PrintEvent;

public class testeMetodo {
    public static void main(String[] args) {
        conta contaThalles = new conta();

        contaThalles.saldo = 100;
        //System.out.println("Saldo inicial: " + contaThalles.saldo);

        contaThalles.deposita(50);
        //System.out.println("Saldo após deposito: " + contaThalles.saldo);

        contaThalles.saque(70);
        //System.out.println("Saldo após saque: " + contaThalles.saldo);

        conta contaTaisy = new conta();
        contaTaisy.deposita(1000);

        if(contaTaisy.transfere(500, contaThalles)){
            System.out.println("Transferência feita com sucesso! ");
        }else{
            System.out.println("Saldo insuficiente!");
        }

        //System.out.println("Conta do Thalles após transferencia: " + contaThalles.saldo);
        System.out.println("Saldo atual: " + contaTaisy.saldo);

        contaThalles.titular = "Thalles Cerqueira";
        System.out.println("Titular: " + contaThalles.titular);
    }
}
