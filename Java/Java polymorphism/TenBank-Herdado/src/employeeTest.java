public class employeeTest {
    public static void main(String[] args) {
        employee2 joao = new employee2();

        joao.setName("João Cardoso");
        joao.setCpf("123.456.789-10");
        joao.setSalary(1000);

        System.out.println("Name: " + joao.getName());
        System.out.println("CPF: " + joao.getCpf());
        System.out.println("Salary: $" + joao.getSalary());

        joao.setType(1);

        System.out.println("Bonus: $" + joao.getBonus());

    }
}
