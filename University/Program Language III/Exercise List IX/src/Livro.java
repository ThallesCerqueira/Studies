public class Livro {

    private String titulo;
    private String autor;
    private int nroPaginas;
    private int anoPublicacao;

    public Livro( String titulo, String autor, int nroPaginas, int anoPublicacao ) {
        if( validaLivro( titulo, autor, nroPaginas, anoPublicacao ) ) {
            this.titulo = titulo;
            this.autor = autor;
            this.nroPaginas = nroPaginas;
            this.anoPublicacao = anoPublicacao;
        }else{
            this.titulo = "Sem título";
            this.autor = "Desconhecido";
            this.nroPaginas = 1;
            this.anoPublicacao = 1900;
        }
    }

    public Livro() {
        this( "", "", 1, 1900 );
    }

    private boolean validaLivro( String titulo, String autor, int nroPaginas, int anoPublicacao ) {
        return titulo != "" && autor != "" && nroPaginas > 0 && anoPublicacao >= 1900;
    }

    public String toString() {
        return "Título: " + this.titulo + "\nAutor: " + this.autor + "\nNúmero de páginas: " +
                this.nroPaginas + "\nAno Publicação: " + this.anoPublicacao;
    }

    public boolean isOlder( Livro livro ) {
        return !(this.anoPublicacao > livro.anoPublicacao);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getNroPaginas() {
        return this.nroPaginas;
    }

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }
}
