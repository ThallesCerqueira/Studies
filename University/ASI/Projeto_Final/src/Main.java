public class Main {
    public static void main(String[] args) {

        int escMenuPrincipal;
        Utils utils = new Utils();
        Aluno aluno = new Aluno();
        Professor professor = new Professor();
        Administrador administrador = new Administrador();

        do {

            utils.menuPrincipal();
            escMenuPrincipal =  Utils.escolha(1,4);

            switch (escMenuPrincipal) {
                case 1 -> administrador.hubAdm();
                case 2 -> professor.hubProf();
                case 3 -> aluno.hubAluno();
                case 4 -> {

                }
            }

        }while (escMenuPrincipal != 4);

    }
}