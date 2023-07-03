package produtosBancarios.emprestimos;

public class EmprestimoPessoal extends Emprestimo {

    private static final double taxa = 0.20d;

    // Construtor com 2 parâmetros
    public EmprestimoPessoal( int qtdParcelas, double valor ) {

        // Chamando Construtor da Super Class
        // Diferença na taxa de Juros
        super( qtdParcelas, valor + ( valor * taxa ) );
    }

}
