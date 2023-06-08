package Pessoas;

public class ChefeDeDepartamento extends Funcionario {

    private String departamento;
    private Data promocaoChefe;

    public ChefeDeDepartamento( String nome, long id, Data nascimento, Data admissao, double salario, String departamento, Data promocaoChefe ) {
        super( nome, id, nascimento, admissao, salario );

        if( validaChefe( departamento, promocaoChefe ) ) {
            this.departamento = departamento;
            this.promocaoChefe = promocaoChefe;
        }else{
            this.departamento = "Desconhecido";
            this.promocaoChefe = new Data( 1, 1, 2000 );
        }
    }

    private boolean validaChefe( String departamento, Data promocaoChefe ) {
        return departamento != "" && promocaoChefe != null;
    }

    @Override
    public String toString() {
        return super.toString() + ", Departamento: " + this.departamento + ", Promoção a Chefe: " + this.promocaoChefe.toString();
    }

    @Override
    public double calculaEmprestimo() {
        return super.getSalario() * 3;
    }

}