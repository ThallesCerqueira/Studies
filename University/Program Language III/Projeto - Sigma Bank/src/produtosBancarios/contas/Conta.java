package produtosBancarios.contas;

import pessoas.Pessoa;
import pessoas.PessoaFisica;
import produtosBancarios.cartoes.Cartao;
import produtosBancarios.emprestimos.Emprestimo;
import produtosBancarios.financiamentos.Financiamento;
import utils.Data;

public class Conta {

    private int numConta;
    private Pessoa cliente;
    private Cartao cartao;
    private Emprestimo emprestimo;
    private Financiamento financiamento;

    public Conta(String nome, long cpf, Data nascimento, String endereco, double renda ) {
        this.cliente = new PessoaFisica( nome, cpf, nascimento, endereco, renda);
    }
}
