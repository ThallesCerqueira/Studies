public class Euro extends Moeda {

    public Euro(double valor){
        super (valor);
    }

    @Override
    public String info(){
        return "Moeda: Euro, valor: " + valor;
    }

    @Override
    public double converter(){
        return valor * 5.40;

    }

}
