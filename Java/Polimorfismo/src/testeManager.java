public class testeManager {
    public static void main(String[] args) {
        manager thalles = new manager();
        employee trabalhador = new employee();

        thalles.setName("Thalles Cerqueira");
        thalles.setCpf("093");
        thalles.setSalary(10000);

        trabalhador.setSalary(1000);

        System.out.println("Nome: " + thalles.getName());
        System.out.println("CPF: " + thalles.getCpf());
        System.out.println("Salário: $" + thalles.getSalary());

        thalles.setSenha(222);
        boolean autentica = thalles.autentica(222);
        System.out.println(autentica);

        System.out.println("Bonus manager: " + thalles.getBonus());
        System.out.println("Bonus trabalhador: " + trabalhador.getBonus());

    }
}
