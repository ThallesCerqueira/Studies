public class testeReferencias {
    public static void main(String[] args) {

        manager g1 = new manager();
        g1.setName("Thalles");
        g1.setSalary(5000);

        employee func1 = new employee();
        func1.setName("João");
        func1.setSalary(1000);

        editorVideo ed1 = new editorVideo();
        ed1.setName("Éder");
        ed1.setSalary(2000);


        controleBonificacao controle = new controleBonificacao();
        controle.registra(g1);
        controle.registra(func1);
        controle.registra(ed1);

        System.out.println("Nome do gerente: " + g1.getName());
        System.out.println("Nome do funcionário: " + func1.getName());
        System.out.println("Nome do editor: " + ed1.getName());
        System.out.println();
        System.out.println("Total de bonificação: "+controle.getSoma());
    }
}
