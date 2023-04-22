public class Main {

    public static void main(String[] args) {

        //Instanciando os objetos
        Contato contato = new Contato();
        Data data = new Data();
        LampadaEstaLigada lampadaEstaLigada = new LampadaEstaLigada();
        LampadaLuminosidade lampadaLuminosidade = new LampadaLuminosidade();
        LampadaTresEstados lampadaTresEstados = new LampadaTresEstados();
        Ponto2D ponto2D = new Ponto2D();
        VendaLampada vendaLampada = new VendaLampada();

        //Exemplo para a Classe Data
        System.out.println("=====Exemplo para a Classe Data=====");
        data.inicializarData();
        data.setDia(02);
        data.setMes(04);
        data.setAno(2023);
        System.out.println("Data válida? " + data.verificarData());
        data.imprimirData();
        data.imprimirDataExtenso();

        System.out.println();

        //Exemplo para a Classe Contato
        System.out.println("=====Exemplo para a Classe Contato=====");
        contato.inicializarContato();
        contato.setNome("Thalles");
        contato.setEmail("thallescerqueira.dev@gmail.com");
        contato.setTelefone("73999998888");
        contato.setDataNascimento("10/10/2000");
        contato.imprimirContato();

        System.out.println();

        //Exemplo para a Classe LampadaTresEstados
        System.out.println("=====Exemplo para a Classe LampadaTresEstados=====");
        lampadaTresEstados.acende();
        lampadaTresEstados.mostraEstado();
        lampadaTresEstados.meiaLuz();
        lampadaTresEstados.mostraEstado();
        lampadaTresEstados.apaga();
        lampadaTresEstados.mostraEstado();

        System.out.println();

        //Exemplo para a Classe LampadaLuminosidade
        System.out.println("=====Exemplo para a Classe LampadaLuminosidade=====");
        lampadaLuminosidade.setValorLuminosidade(50);
        lampadaLuminosidade.atribuirEstado();
        lampadaLuminosidade.mostraEstado();

        System.out.println();

        //Exemplo para a Classe LampadaEstaLigada
        System.out.println("=====Exemplo para a Classe LampadaEstaLigada=====");
        lampadaEstaLigada.setValorLuminosidade(100);
        lampadaEstaLigada.atribuirEstado();
        System.out.println("Lampada ligada? " + lampadaEstaLigada.estaLigada());
        lampadaEstaLigada.mostraEstado();

        System.out.println();

        //Exemplo para a Classe VendaLampada
        System.out.println("=====Exemplo para a Classe VendaLampada=====");
        vendaLampada.adicionarQuantidade(100);
        vendaLampada.removerQuantidade(2);
        vendaLampada.mostrarQuantidade();
        vendaLampada.mudarValor(100);
        vendaLampada.valorAPagar(5);

        System.out.println();

        //Exemplo para a Classe Ponto2D
        System.out.println("=====Exemplo para a Classe Ponto2D=====");
        ponto2D.setX(10);
        ponto2D.setY(5);
        System.out.println("isEixoX? " + ponto2D.isEixoX());
        System.out.println("isEixoY? " + ponto2D.isEixoY());
        System.out.println("isEixos? " + ponto2D.isEixos());
        ponto2D.imprimirPonto();
        System.out.println("Quadrante: " + ponto2D.quadrante());
        System.out.println("Distância entre os pontos: " + ponto2D.distancia(2,3));

    }

}