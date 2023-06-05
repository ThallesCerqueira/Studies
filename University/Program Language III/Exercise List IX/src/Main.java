public class Main {

    public static void main(String[] args) {

        Ponto2D ponto2D = new Ponto2D( 3, 5 );
        Ponto3DComposicao ponto3DComposicao = new Ponto3DComposicao();
        Ponto3DHeranca ponto3DHeranca = new Ponto3DHeranca( 0, 0, 0 );
        Livro livro = new Livro( "O homem mais rico da Babilônia", "George S. Clason", 157, 2017 );
        Livro livro2 = new Livro( "A revolução dos bixos", "George Orwell", 142, 2021 );
        LivroBiblioteca livroBiblioteca = new LivroBiblioteca( "O homem mais rico da Babilônia", "George S. Clason", 157, 2017 );
        LivroLivraria livroLivraria = new LivroLivraria( "Do mil ao milhão", "Thiago Nigro", 222, 2018, 15.0f, 1 );
        Cilindro cilindro = new Cilindro( 1, 2, 3, 4, 5 );
        Cone cone = new Cone( 4, 5, 6, 7, 8 );

        // Exemplo para a classe Ponto2D
        System.out.println( "========== Exemplo para a classe Ponto2D ==========" );
        System.out.println( ponto2D.toString() );
        System.out.println( "inAxisX? " + ponto2D.inAxisX() );
        System.out.println( "inAxisY? " + ponto2D.inAxisY() );
        System.out.println( "inAxis? " + ponto2D.inAxis() );
        System.out.println( "inOrigin? " + ponto2D.isOrigin() );
        System.out.println( "Distance of (2, 7): " + ponto2D.distance( 2, 7 ) );

        // Exemplo para a classe Ponto3DComposicao
        System.out.println();
        System.out.println( "========= Exemplo para a classe Ponto3DComposicao =========" );
        System.out.println( ponto3DComposicao.toString() );
        System.out.println( "inAxisX? " + ponto3DComposicao.inAxisX() );
        System.out.println( "inAxisY? " + ponto3DComposicao.inAxisY() );
        System.out.println( "inAxisZ? " + ponto3DComposicao.inAxisZ() );
        System.out.println( "inAxis? " + ponto3DComposicao.inAxis() );
        System.out.println( "inOrigin? " + ponto3DComposicao.isOrigin() );
        System.out.println( "Distance of (8, 1, 4): " + ponto3DComposicao.distance( 8, 1, 4 ) );

        // Exemplo para a classe Ponto3DHeranca
        System.out.println();
        System.out.println( "========= Exemplo para a classe Ponto3DHeranca ==========" );
        System.out.println( ponto3DHeranca.toString() );
        System.out.println( "inAxisX? " + ponto3DHeranca.inAxisX() );
        System.out.println( "inAxisY? " + ponto3DHeranca.inAxisY() );
        System.out.println( "inAxisZ? " + ponto3DHeranca.inAxisZ() );
        System.out.println( "inAxis? " + ponto3DHeranca.inAxis() );
        System.out.println( "inOrigin? " + ponto3DHeranca.isOrigin() );
        System.out.println( "Distance of (8, 1, 4): " + ponto3DHeranca.distance( 8, 1, 4 ) );

        // Diferença
        System.out.println("""
                \n
                DIFERENÇA:\s
                - O modo como é feita a reutilização de código.
                - Os contrutores são diferentes, pois para a Herança é necesário chamar o construtor da super classe.
                - Para Herança também é possível a reescrita de métodos, coisa que em Composição, Agregação e Associação não é possível fazer.
                - E também no caso de Herança, as funcionalidades não são delegadas.""");


        // Exemplo para a classe Livro
        System.out.println();
        System.out.println();
        System.out.println( "========== Exemplo para a classe Livro =========" );
        System.out.println( livro.toString() );
        System.out.println( "Livro A revolução dos bixos, isOlder? " + livro.isOlder( livro2 ) );

        // Exemplo para a classe LivroBiblioteca
        System.out.println();
        System.out.println( "========== Exemplo para a classe LivroBiblioteca =========" );
        System.out.println( livroBiblioteca.toString() );
        System.out.println( "Está disponível para emprestar? " + livroBiblioteca.isAvailable() );
        System.out.println( "Reserva pra mim?! " + livroBiblioteca.borrow( "01/06/2023" ) );
        System.out.println( "Qual data de devolução? " + livroBiblioteca.getDataDevolucao() );

        // Exemplo para a classe LivroLivraria
        System.out.println();
        System.out.println( "========= Exemplo para a classe LivroLivraria =========" );
        System.out.println( livroLivraria.toString() );
        System.out.println( "isAvailable? " + livroLivraria.isAvailable() );
        System.out.println( "Quero 1 livro! Consegui comprar? " + livroLivraria.sell( 1 ) );

        // Exemplo para a classe Cilindro
        System.out.println();
        System.out.println( "========== Exemplo para a classe Cilindro =========" );
        System.out.println( cilindro.toString() );
        System.out.println( "Volume: " + cilindro.volume() );
        System.out.println( "Área: " + cilindro.area() );

        // Exemplo para a classe Cone
        System.out.println();
        System.out.println( "========== Exemplo para a classe Cone ==========" );
        System.out.println( cone.toString() );
        System.out.println( "Volume: " + cone.volume() );
        System.out.println( "Área: " + cone.area() );
    }
}