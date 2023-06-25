package produtosBancarios.emprestimos;

public class EmprestimoConsignado extends Emprestimo{

    // Diferença na taxa de Juros
    public EmprestimoConsignado( int qtdParcelas, int valor ) {
        super( qtdParcelas, valor + ( valor * 0.10d ) );
    }

}
