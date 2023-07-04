package pessoas;

import java.util.ArrayList;

public class Funcionario extends Pessoa {

    // Atributos da classe
    private String cargo;

    // Construtor com 4 parâmetros
    public Funcionario( String nome, String cargo, String endereco, double salario ) {
        super( nome, endereco, salario );

        this.cargo = cargo;
    }

    // Método para pegar o cargo
    public String getCargo() {
        return this.cargo;
    }

    // Método para inicializar os funcionarios
    public static void inicializaFuncionarios(ArrayList<Pessoa> list) {

        String nome, cargo, endereco;
        double salario;

        list.add( new Funcionario( "Pedro", "Caixa", "Ladário", 1500 ) );
        list.add( new Funcionario( "Thiago", "Secretário", "Corcova", 2200 ) );
        list.add( new Funcionario( "João", "Balconista", "California", 1500 ) );
        list.add( new Funcionario( "André", "Gerente", "Goés Calmon", 3000 ) );
        list.add( new Funcionario( "Bartolomeu", "Chefe de setor", "Sarinha", 5000 ) );
        list.add( new Funcionario( "Filipe", "Diretor Executivo", "Jaçanã", 15000 ) );


    }

}
