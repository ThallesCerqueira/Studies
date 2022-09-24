public class exampleForArray {
    public static void main(String[] args){
        String alunos[] = {"Taisy", "Thalles", "Davi", "Ivone"};

        for(int x = 0; x < alunos.length; x++){
            System.out.println("Aluno do índice " + (x+1) + " é: " + alunos[x]);
        }

        System.out.println("\nExample with For Each");

        for(String aluno: alunos){
            System.out.println("O nome do aluno é: " + aluno);
        }
    }
}
