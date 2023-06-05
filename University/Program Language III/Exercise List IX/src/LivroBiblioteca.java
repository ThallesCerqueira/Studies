public class LivroBiblioteca extends Livro {

    private boolean emprestado;
    private String dataDevolucao;

    public LivroBiblioteca( String titulo, String autor, int nroPaginas, int anoPublicacao ) {
        super( titulo, autor, nroPaginas, anoPublicacao );
        this.emprestado = false;
        this.dataDevolucao = "";
    }

    public LivroBiblioteca() {
        this( "", "", 1, 1900 );
    }

    public String toString() {
        return "Título: " + super.getTitulo() + "\nAutor: " + super.getAutor() + "\nNúmero Páginas: " +
                super.getNroPaginas() + "\nAno Publicação: " + super.getAnoPublicacao() + "\nEmprestado: " + this.emprestado
                + "\nData Devolução: " + this.dataDevolucao;
    }

    public boolean isOlder(LivroBiblioteca livro) {
        return super.getAnoPublicacao() > livro.getAnoPublicacao();
    }

    public boolean isAvailable() {
        return !this.emprestado;
    }

    public boolean borrow( String dataDevolucao ) {

        if( isAvailable() ) {
            this.emprestado = true;
            this.dataDevolucao = dataDevolucao;
            return true;
        }

        return false;
    }

    public String getDataDevolucao() {
        return this.dataDevolucao;
    }
}
