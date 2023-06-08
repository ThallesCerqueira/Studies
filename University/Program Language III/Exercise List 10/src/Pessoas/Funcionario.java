package Pessoas;

public class Funcionario extends Pessoa {

    private Double salario;
    private Data admissao;

    public Funcionario( String nome, long id, Data nascimento, Data admissao, double salario ) {
        super( nome, id, nascimento );

        if( validaFuncionario( admissao, salario ) ) {
            this.admissao = admissao;
            this.salario = salario;
        }else{
            this.admissao = new Data( 1, 1, 2000 );
            this.salario = 0d;
        }
    }

    public Double getSalario() {
        return this.salario;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salário: " + this.salario + ", Admissão: " + this.admissao.toString();
    }

    public double qualSalario() {
        return this.salario;
    }

    private boolean validaFuncionario(Data admissao, double salario) {
        return admissao != null && salario >= 0;
    }

    @Override
    public double calculaEmprestimo() {
        return 1000d + this.salario * 0.75d;
    }

}
