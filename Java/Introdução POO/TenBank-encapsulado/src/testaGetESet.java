public class testaGetESet {
    public static void main(String[] args) {
        conta contaTalles = new conta(100, 70);
        cliente Talles = new cliente();

        contaTalles.setNumero(45604);

        System.out.println("Número: " + contaTalles.getNumero());

        contaTalles.setTitular(Talles);

        Talles.setNome("Thalles Cerqueira");
        Talles.setCpf("123.345.789-12");
        Talles.setProfissao("Test Automation Engineer");
    }
}
