public class conta {
    private double saldo;
    int agencia;
    int numero;
    cliente titular;

    public void deposita(double valor){
        saldo+= valor;
    }

    public boolean saque(double valor){
        
        if(valor >= 0){
            if(saldo >= valor){
                saldo -= valor;
                return true;
            }else{
                return false;
            }
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

    public double getSaldo(){
        return saldo;
    }
}
