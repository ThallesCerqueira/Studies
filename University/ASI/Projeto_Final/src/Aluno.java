import java.util.ArrayList;

public class Aluno extends Usuario {

    private ArrayList<Curso> meusCursos = new ArrayList<>();
    private final Utils utils = new Utils();

    public void getMeusCursos() {

        for(Curso curso: meusCursos) {
            System.out.println(curso.getNome());
        }

    }

    public void hubAluno() {
        int opcao;

        do {
            utils.menuPrincAluno();
            opcao = Utils.escolha(1,6);

            switch (opcao) {
                case 1 -> novoCurso();
                case 2 -> getMeusCursos();
                case 3 -> fazerAvaliacao();
                case 4 -> emitirCertificado();
                case 5 -> meusDados();
                case 6 -> {

                }
            }
        } while (opcao != 6);

    }

    private void novoCurso() {
    }

    private void meusDados() {
    }

    private void emitirCertificado() {
    }

    private void fazerAvaliacao() {

        int qtdCursos, escolha;
        Curso curso;

        setMeusCurso(new CursoJava());
        setMeusCurso(new CursoPOO());
        qtdCursos = meusCursos.size();
        getMeusCursos();

        System.out.println("Indice do curso");
        escolha = Utils.escolha(1, qtdCursos);

        curso = meusCursos.get(escolha);
        curso.questoes(curso);


    }

    public void setMeusCurso(Curso curso) {
        this.meusCursos.add(curso);
    }
}
