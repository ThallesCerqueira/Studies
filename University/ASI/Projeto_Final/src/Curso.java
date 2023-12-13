import java.util.Scanner;

public class Curso {

    private int id;
    private String nome;
    private String descricao;
    private String[] questoes = new String[5];
    private String professor;
    private int numAulas;

    public void realizarMatricula() {}

    public void cancelarMatricula() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumAulas() {
        return numAulas;
    }

    public void setNumAulas(int numAulas) {
        this.numAulas = numAulas;
    }

    public void questoes(Curso curso) {
        int esc;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            System.out.println(curso.getQuestao(i));
            esc = sc.nextInt();
        }
    }

    private String getQuestao(int i) {
        setQuestoes();
        return this.questoes[i];
    }

    private void setQuestoes() {
        this.questoes[0] = """
                O que é Java?
                1 - Um tipo de café
                2 - Uma linguagem de programação
                3 - Uma cidade na Indonésia
                4 - Uma marca de carros\s""";

        this.questoes[1] = """
                Qual é a principal finalidade da JVM (Java Virtual Machine)?
                1 - Executar código JavaScript
                2 - Compilar código Java
                3 - Executar código Java
                4 - Depurar código Java
                \s""";

        this.questoes[2] = """
                O que é um construtor em Java?
                1 - Uma máquina de construção civil
                2 - Um método especial para inicializar objetos
                3 - Um operador lógico
                4 - Uma classe abstrata
                \s""";

        this.questoes[3] = """
                Qual palavra-chave é usada para herança em Java?
                1 - extend
                2 - inheritance
                3 - inherits
                4 - subclass
                \s""";

        this.questoes[4] = """
                Como você lida com exceções em Java?
                1 - Usando a palavra-chave exception
                2 - Ignorando-as, já que Java não suporta tratamento de exceções
                3 - Utilizando os blocos try, catch e finally
                4 - A linguagem Java não permite exceções
                \s""";
    }
}
