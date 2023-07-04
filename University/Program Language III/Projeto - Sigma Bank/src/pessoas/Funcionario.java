package pessoas;

public class Funcionario extends Pessoa {

    private String cargo;

    public Funcionario( String nome, String cargo, String endereco, double salario ) {
        super( nome, endereco, salario );

        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

}
