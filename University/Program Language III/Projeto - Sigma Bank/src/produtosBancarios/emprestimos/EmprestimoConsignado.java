package produtosBancarios.emprestimos;

public class EmprestimoConsignado extends Emprestimo{

    // Construtor com 2 parâmetros
    public EmprestimoConsignado( int qtdParcelas, double valor ) {

        // Chamando construtor da Super Class
        // Diferença na taxa de Juros
        super( qtdParcelas, valor + ( valor * 0.10d ) );
    }

}