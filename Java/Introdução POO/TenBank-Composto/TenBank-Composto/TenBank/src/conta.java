public class conta {
    double saldo;
    int agencia;
    int numero;
    String titular;

    public void deposita(double valor){
        saldo+= valor;
    }

    public boolean saque(double valor){
        
        if(saldo >= valor){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean transfere(double valor, conta destino){

        if(saldo >= valor){

            saldo -=valor;
            destino.saldo += valor;

            return true;
        }

        return false;

    }
}
