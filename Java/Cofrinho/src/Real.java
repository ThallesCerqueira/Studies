public class Real extends Moeda {

    // Construtor da classe Real
    public Real(double valor){
        super (valor);
    }

    // Sobreescrita do método info, previsto pela classe Moeda
    @Override
    public String info(){
        return "Moeda: Real, valor: " + valor;
    }

    // Sobreescrita do método converter, previsa pela classe Moeda
    @Override
    public double converter(){
        return valor;

    }

}