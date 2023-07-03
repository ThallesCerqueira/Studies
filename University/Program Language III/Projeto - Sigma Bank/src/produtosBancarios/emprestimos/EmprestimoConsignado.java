package produtosBancarios.emprestimos;

public class EmprestimoConsignado extends Emprestimo {

    private static final double taxa = 0.10d;

    // Construtor com 2 parâmetros
    public EmprestimoConsignado( int qtdParcelas, double valor ) {

        // Chamando construtor da Super Class
        // Diferença na taxa de Juros
        super( qtdParcelas, valor + ( valor * taxa ) );
    }

}