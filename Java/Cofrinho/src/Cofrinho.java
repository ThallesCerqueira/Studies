import java.util.ArrayList;

public class Cofrinho {

    private ArrayList<Moeda> listaMoedas;

    public Cofrinho(){
        this.listaMoedas = new ArrayList<>();
    }

    public void adicionar(Moeda item) {
        this.listaMoedas.add(item);
    }

    public double remover(Moeda item) {

        double valor;

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

    public void listagemMoedas() {

        if (listaMoedas.size()==0){
            System.out.println("Nenhuma moeda no cofrinho");
            return;
        }

        for(Moeda elemento: listaMoedas){
            System.out.println(elemento.info());
        }

    }

    public double totalConvertido(){
        double total = 0;

        for(Moeda elemento: listaMoedas){
            total += elemento.converter();
        }

        return total;
    }




}
