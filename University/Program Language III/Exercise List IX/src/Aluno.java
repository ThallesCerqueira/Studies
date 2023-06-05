import java.util.Objects;
import java.util.Random;

public class Aluno {

    private String nome;
    private int matricula;
    private String dataAdmissao;
    private int semestre;
    private String tipoCurso;
    private double mensalidade;

    public Aluno( String nome, int matricula, String dataAdmissao, int semestre, String tipoCurso ) {

        if( alunoValido( nome, matricula, dataAdmissao, semestre, tipoCurso ) ) {
            this.nome = nome;
            this.matricula = matricula;
            this.dataAdmissao = dataAdmissao;
            this.semestre = semestre;
            this.tipoCurso = tipoCurso;
            this.mensalidade = calculaMensalidade( tipoCurso );
        }else {
            Random rd = new Random();
            this.nome = "Sem nome";
            this.matricula = rd.nextInt();
            this.dataAdmissao = "01/01/2023";
            this.semestre = 1;
            this.tipoCurso = "Computação";
            this.mensalidade = calculaMensalidade( "Computação" );
        }

    }

    private double calculaMensalidade( String tipoCurso ) {

        switch (tipoCurso) {
            case "Engenharias":


        }

        return 0;
    }

    private boolean alunoValido(String nome, int matricula, String dataAdmissao, int semestre, String tipoCurso) {

        if( Objects.equals(tipoCurso, "Engenharia") ||
                Objects.equals(tipoCurso, "Computação") ||
                Objects.equals(tipoCurso, "Letras") ||
                Objects.equals(tipoCurso, "Biológicas")) {
            return nome != "" && matricula >= 1 && dataAdmissao != "" && semestre > 0 && semestre < 3;
        }

        return false;

    }
}
