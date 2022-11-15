public class testaBanco {
    public static void main(String[] args) {
        cliente thalles = new cliente();

        thalles.nome = "Thalles Cerqueira";
        thalles.cpf = "09300725530";
        thalles.profissao = "Engenheiro de automação";

        conta contaThalles = new conta();

        contaThalles.deposita(100);

        contaThalles.titular = thalles;

        System.out.println(contaThalles.titular.nome);
    }
}
