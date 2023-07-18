public class Euro extends Moeda {

    // Construtor da classe Euro
    public Euro(double valor){
        super (valor);
    }

    // Sobreescrita do método info, previsto pela classe Moeda
    @Override
    public String info(){
        return "Moeda: Euro, valor: " + valor;
    }

    // Sobreescrita do método converter, previsa pela classe Moeda
    @Override
    public double converter(){
        return valor * 5.40;

    }

}
