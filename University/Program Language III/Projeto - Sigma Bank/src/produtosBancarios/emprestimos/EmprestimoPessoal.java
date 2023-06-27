package produtosBancarios.emprestimos;

public class EmprestimoPessoal extends Emprestimo {

    // Diferença na taxa de Juros
    public EmprestimoPessoal( int qtdParcelas, double valor ) {
        super( qtdParcelas, valor + (valor * 0.20d) );
    }
}
