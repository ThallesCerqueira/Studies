public class criaConta {
    public static void main(String[] args){
        conta primeiraConta = new conta();
        primeiraConta.saldo = 1000;

        System.out.println("Primeira conta: " + primeiraConta.saldo);

        conta segundaConta = new conta();

        segundaConta.saldo = 2000;

        System.out.println("Segunda conta: " + segundaConta.saldo);


    }
}
