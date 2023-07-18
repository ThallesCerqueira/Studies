public class Dolar extends Moeda {

    // Construtor da classe Dolar
    public Dolar(double valor){
        super (valor);
    }

    // Sobreescrita do método info, previsto pela classe Moeda
    @Override
    public String info(){
        return "Moeda: Dolar, valor: " + valor;
    }

    // Sobreescrita do método converter, previsa pela classe Moeda
    @Override
    public double converter(){
        return valor * 4.8;

    }

}