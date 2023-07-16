public class Dolar extends Moeda {

    public Dolar(double valor){
        super (valor);
    }

    @Override
    public String info(){
        return "Moeda: Dolar, valor: " + valor;
    }

    @Override
    public double converter(){
        return valor * 4.8;

    }

}
