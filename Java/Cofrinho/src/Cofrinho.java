import java.util.ArrayList;

public class Cofrinho {

    // Atributos da classe Cofrinho
    private ArrayList<Moeda> listaMoedas;

    // Construtor da classe
    public Cofrinho(){
        this.listaMoedas = new ArrayList<>();
    }

    // Método polimórfico para adicionar moedas ao cofre
    public void adicionar(Moeda item) {
        this.listaMoedas.add(item);
    }

    // Método polimórfico para remover moedas do cofre
    public double remover(Moeda item) {

        double valor;

        // Percorrendo o cofre para saber se a moeda solicitada está dentro dele
        for(Moeda elemento: listaMoedas){
            if (elemento.getClass() == item.getClass()){
                valor = elemento.valor;
                listaMoedas.remove(elemento);
                return valor;
            }
        }

        System.out.println("Moeda não encontrada");

        return 0;
    }

    // Método polimórfico para listagem de moedas
    public void listagemMoedas() {

        // Verificando se há moedas no cofre
        if (listaMoedas.size()==0){
            System.out.println("Nenhuma moeda no cofrinho");
            return;
        }

        // Listando as moedas do cofre
        for(Moeda elemento: listaMoedas){
            System.out.println(elemento.info());
        }

    }

    // Método para contabilizar todos os valores convertidos
    public double totalConvertido(){
        double total = 0;

        for(Moeda elemento: listaMoedas){
            total += elemento.converter();
        }

        return total;
    }

}