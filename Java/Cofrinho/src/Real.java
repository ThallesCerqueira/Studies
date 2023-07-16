public class Real extends Moeda {

    public Real(double valor){
        super (valor);
    }

    @Override
    public String info(){
        return "Moeda: Real, valor: " + valor;
    }

    @Override
    public double converter(){
        return valor;

    }

}
