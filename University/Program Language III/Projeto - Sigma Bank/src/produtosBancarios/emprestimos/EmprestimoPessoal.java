package produtosBancarios.emprestimos;

public class EmprestimoPessoal extends Emprestimo {

    // Construtor com 2 parâmetros
    public EmprestimoPessoal( int qtdParcelas, double valor ) {

        // Chamando Construtor da Super Class
        // Diferença na taxa de Juros
        super( qtdParcelas, valor + ( valor * 0.20d ) );
    }

}
