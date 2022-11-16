public class testaValores {
    public static void main(String[] args) {
        conta contaTaisy = new conta(100, 70);
        cliente clienteTaisy = new cliente();

        System.out.println(conta.getTotal());

        contaTaisy.setAgencia(-10);
        contaTaisy.setNumero(-2);

    }
}
