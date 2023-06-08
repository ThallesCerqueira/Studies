public class LivroLivraria extends Livro {

    private float preco;
    private int estoque;

    public LivroLivraria( String titulo, String autor, int nroPaginas, int anoPublicacao, float preco, int estoque ) {

        super( titulo, autor, nroPaginas, anoPublicacao);

        if( livroLivariaValido( preco, estoque ) ) {
            this.preco = preco;
            this.estoque = estoque;
        }else{
            this.preco = 0;
            this.estoque = 0;
        }

    }

    public LivroLivraria() {
        this( "", "", 1, 1900, 0, 0 );
    }

    public String toString() {
        return "Título: " + super.getTitulo() + "\nAutor: " + super.getAutor() + "\nNúmero Páginas: " + super.getNroPaginas() +
                "\nAno Publicação: " + super.getAnoPublicacao() + "\nPreço: " + this.preco + "\nEstoque: " + this.estoque;
    }

    public boolean isOlder(LivroLivraria livro) {
        return super.getAnoPublicacao() > livro.getAnoPublicacao();
    }

    public boolean isAvailable() {
        return this.estoque > 0;
    }

    public boolean sell( int quantidade ) {

        if( isAvailable() && this.estoque >= quantidade ) {
            this.estoque -= quantidade;
            return true;
        }

        return false;

    }

    public boolean sell() {
        return this.sell( 1 );
    }

    private boolean livroLivariaValido(float preco, int estoque) {
        return preco >= 0 && estoque >= 0;
    }

}
